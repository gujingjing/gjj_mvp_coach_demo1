package mvp.gjj.androidbaselib.base;

import android.app.Activity;
import android.app.Application;

import mvp.gjj.androidbaselib.cash.spCash.SharedPrefsUtil;
import mvp.gjj.androidbaselib.manager.AppManager;
import mvp.gjj.androidbaselib.netstate.NetChangeObserver;
import mvp.gjj.androidbaselib.netstate.NetworkStateReceiver;
import mvp.gjj.androidbaselib.tools.LogUtils;
import mvp.gjj.androidbaselib.tools.NetWorkUtil;

/**
 * 作者：gjj on 2016/1/5 11:34
 * 邮箱：Gujj512@163.com
 */
public class BaseApplication extends Application {
    private NetChangeObserver mNetChangeObserver;
    public Activity mCurrentActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        initLogUtils();
        initSPUtils();
        registerNetWorkStateListener();// 注册网络状态监测器
        NetworkStateReceiver.registerNetworkStateReceiver(this);//注册全局监听网络状态的观察者
    }
    private void initSPUtils(){
        //初始化配置sp文件
        SharedPrefsUtil.SHARE_SP_NAME="gjj_shareSP";
    }
    private void initLogUtils() {
        // 配置日志是否输出(默认true)
        LogUtils.setIfLog(true);

        // 配置日志前缀
        LogUtils.customTagPrefix = "gjj-";
    }
    private void registerNetWorkStateListener() {
        mNetChangeObserver = new NetChangeObserver() {
            @Override
            public void onConnect(NetWorkUtil.NetType type) {
                super.onConnect(type);
                try {
                    BaseApplication.this.onConnect(type);
                } catch (Exception e) {
                    LogUtils.e("网络监听异常===",e);
                }
            }

            @Override
            public void onDisConnect() {
                super.onDisConnect();
                try {
                    BaseApplication.this.onDisConnect();
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };
        NetworkStateReceiver.registerObserver(mNetChangeObserver);
    }

    /**
     * 当前没有网络连接通知
     */
    public void onDisConnect() {
        mCurrentActivity = AppManager.getAppManager().currentActivity();
        if (mCurrentActivity != null) {
            if (mCurrentActivity instanceof BaseActivity) {
                ((BaseActivity) mCurrentActivity).onDisConnect();
            }
        }
    }

    /**
     * 网络连接连接时通知
     */
    protected void onConnect(NetWorkUtil.NetType type) {
        mCurrentActivity = AppManager.getAppManager().currentActivity();
        if (mCurrentActivity != null) {
            if (mCurrentActivity instanceof BaseActivity) {
                ((BaseActivity) mCurrentActivity).onConnect(type);
            }
        }
    }
}
