package dbmeta.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import dbmeta.model.Column;
import dbmeta.model.Table;
import dbmeta.model.User;
import dbmeta.plugin.shiro.ShiroInterceptor;
import dbmeta.plugin.shiro.ShiroPlugin;

/**
 * Created by lex on 2017/11/22.
 */
public class AppConfig extends JFinalConfig {
    private Routes routes = new RouteConfig();

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
        me.add(arp);

        me.add(new ShiroPlugin(routes));
    }

    public void configInterceptor(Interceptors me) {
        me.add(new ShiroInterceptor());
    }

    public void configHandler(Handlers me) {
    }
}
