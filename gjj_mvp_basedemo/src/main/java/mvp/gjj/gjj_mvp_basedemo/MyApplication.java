package mvp.gjj.gjj_mvp_basedemo;

import com.squareup.leakcanary.LeakCanary;

import mvp.gjj.androidbaselib.base.BaseApplication;

/**
 * 作者：gjj on 2016/1/5 21:40
 * 邮箱：xjs250@163.com
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化内存泄漏
        LeakCanary.install(this);
    }
}
