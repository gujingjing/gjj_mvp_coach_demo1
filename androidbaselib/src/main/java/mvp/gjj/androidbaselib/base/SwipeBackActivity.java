package mvp.gjj.androidbaselib.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import mvp.gjj.androidbaselib.R;
import mvp.gjj.androidbaselib.manager.AppManager;
import mvp.gjj.androidbaselib.manager.SystemBarTintManager;
import mvp.gjj.androidbaselib.tools.NetWorkUtil;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.androidbaselib.view.swipebackview.SwipeBackLayout;


/**
 * 作者：gjj on 2016/2/18 10:53
 * 邮箱：Gujj512@163.com
 */
public abstract class SwipeBackActivity <CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceActivity<CV, M, V, P> implements MvpLceView<M> , SwipeBackLayout.SwipeBackListener{

    public SwipeBackActivity context;
    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStateBarColor(R.color.color_blue);//设置最顶部标题栏颜色
        context = this;
        AppManager.getAppManager().addActivity(this);
    }
    @Override
    public void setContentView(int layoutResID) {
        View container=getContainer();
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        swipeBackLayout.addView(view);
        super.setContentView(container);
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new SwipeBackLayout(this);
        swipeBackLayout.setOnSwipeBackListener(this);
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(getResources().getColor(R.color.black_p50));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        return container;
    }

    public void setDragEdge(SwipeBackLayout.DragEdge dragEdge) {
        swipeBackLayout.setDragEdge(dragEdge);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return swipeBackLayout;
    }

    @Override
    public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
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
    public void gotoActivity(Class<? extends Activity> clazz, Bundle bundle, Intent intentFrom, boolean finish){
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
