package yushuangming.test01.u2.app;

import org.litepal.LitePalApplication;
import org.xutils.x;

/**
 * Created by Administrator on 2017/6/19.
 */

public class MyApp extends LitePalApplication  {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
