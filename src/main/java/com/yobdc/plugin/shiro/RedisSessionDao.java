package com.yobdc.plugin.shiro;

import com.jfinal.kit.LogKit;
import com.jfinal.plugin.redis.Redis;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {
    private static String SHIRO_KEY = "dbmeta_shiro";
    /*永不过期*/
    @Getter
    @Setter
    private int expire = 3600;

    /**
     * 如DefaultSessionManager在创建完session后会调用该方法；
     * 如保存到关系数据库/文件系统/NoSQL数据库；即可以实现会话的持久化；
     * 主要此处返回的ID.equals(session.getId())；
     *
     * @param session session
     * @return 返回会话ID
     */
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    /**
     * 根据会话ID获取会话
     *
     * @param serializable 会话ID
     * @return Session
     */
    protected Session doReadSession(Serializable serializable) {
        if (null == serializable) {
            LogKit.error("session id is null");
            return null;
        }

        return Redis.use().hget(SHIRO_KEY, serializable);
    }

    /**
     * 更新会话
     * 如更新会话最后访问时间/停止会话/设置超时时间/设置移除属性等会调用
     *
     * @param session session
     */
    public void update(Session session) {
        saveSession(session);
    }

    /**
     * 删除会话
     * 当会话过期/会话停止（如用户退出时）会调用
     *
     * @param session session
     */
    public void delete(Session session) {
        if (null == session || null == session.getId()) {
            LogKit.error("session or session id is null");
        } else {
            Redis.use().hdel(SHIRO_KEY, session.getId());
            LogKit.debug("delete success shiro key " + session.getId());
        }
    }

    /**
     * 获取当前所有活跃用户，如果用户量多此方法影响性能
     *
     * @return Collection
     */
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();
        Map map = Redis.use().hgetAll(SHIRO_KEY);
        if (!CollectionUtils.isEmpty(map)) {
            Set<Map.Entry> entrySet = map.entrySet();
            for (Map.Entry entry : entrySet) {
                sessions.add((Session) entry.getValue());
            }
        }
        return sessions;
    }

    /**
     * 保存 session
     *
     * @param session Session
     */
    private void saveSession(Session session) {
        if (session == null || session.getId() == null) {
            LogKit.error("session or session id is null");
            return;
        }
        Redis.use().hset(SHIRO_KEY, session.getId(), session);
        Redis.use().expire(SHIRO_KEY, this.expire);
    }
}