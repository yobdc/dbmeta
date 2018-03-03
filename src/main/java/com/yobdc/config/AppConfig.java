package com.yobdc.config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.yobdc.model.Database;
import com.yobdc.model.User;
import com.yobdc.plugin.shiro.ShiroPlugin;
import com.yobdc.model.Column;
import com.yobdc.model.Table;
import com.yobdc.plugin.shiro.ShiroInterceptor;

/**
 * Created by lex on 2017/11/22.
 */
public class AppConfig extends JFinalConfig {
    private static Routes routes = new RouteConfig();

    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(PropKit.getBoolean("devMode"));
        me.setViewType(ViewType.FREE_MARKER);
    }

    public void configRoute(Routes me) {
        me.add(routes);
    }

    public void configEngine(Engine me) {
    }

    public void configPlugin(Plugins me) {
        DruidPlugin dsMysql = new DruidPlugin(
                PropKit.get("jdbcUrl")
                , PropKit.get("user")
                , PropKit.get("password")
        );
        me.add(dsMysql);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dsMysql);
        arp.addMapping("sys_user", User.class);
        arp.addMapping("db_table", Table.class);
        arp.addMapping("db_column", Column.class);
        arp.addMapping("db_database", Database.class);
        me.add(arp);

        me.add(new ShiroPlugin(routes));
    }

    public void configInterceptor(Interceptors me) {
        me.add(new ShiroInterceptor());
    }

    public void configHandler(Handlers me) {
    }

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/");
    }
}
