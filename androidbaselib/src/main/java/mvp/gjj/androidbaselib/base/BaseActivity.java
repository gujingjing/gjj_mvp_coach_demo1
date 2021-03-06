package mvp.gjj.androidbaselib.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import mvp.gjj.androidbaselib.R;
import mvp.gjj.androidbaselib.manager.AppManager;
import mvp.gjj.androidbaselib.manager.SystemBarTintManager;
import mvp.gjj.androidbaselib.netstate.NetworkStateReceiver;
import mvp.gjj.androidbaselib.tools.LogUtils;
import mvp.gjj.androidbaselib.tools.NetWorkUtil;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.androidbaselib.view.swipClassView.SwipeBackLayout;

/**
 * 作者：gjj on 2016/1/4 14:40
 * 邮箱：Gujj512@163.com
 */
public abstract class BaseActivity<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceActivity<CV, M, V, P> implements MvpLceView<M> {

    protected SwipeBackLayout layout;
    public BaseActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //顺序很重要，必须先设置是否需要滑动activity----然后在设置顶部标题栏的颜色
        if (finiActivity()) {
            //是否需要滑动消除界面的主要代码
            layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                    R.layout.activity_base, null);
            layout.attachToActivity(this);
        }
        setStateBarColor(R.color.color_blue);//设置最顶部标题栏颜色
        context = this;
        AppManager.getAppManager().addActivity(this);
    }
    protected void setStateBarColor(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(resId);
            tintManager.setStatusBarDarkMode(true, this);
        }
    }

    /**
     * 是否需要右滑删除界面
     */
    public abstract boolean finiActivity();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    // Press the back button in mobile phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    /**
     * 当没有网络的时候
     */
    public void onDisConnect() {
        ToastUtils.setToastShot(context, "暂时没有网络,请稍后重试");
    }

    /**
     * 当网络连接的时候
     */
    public void onConnect(NetWorkUtil.NetType type) {
        ToastUtils.setToastShot(context, "网络已经连接");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 最简单的返回跳转到activity  -----需要获取result的activity自己写------
     * @param clazz 跳转的activity
     * @param bundle    传递的参数
     * @param intentFrom 传入的intent
     * @param finish    是否需要关闭界面
     */
    public void gotoActivity(Class<? extends Activity> clazz,Bundle bundle,Intent intentFrom,boolean finish){
        Intent intent = (intentFrom==null?new Intent(this, clazz):intentFrom);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }
    public void gotoActivity(Class<? extends Activity> clazz,boolean finish){
        gotoActivity(clazz,null,null,finish);
    }
}
