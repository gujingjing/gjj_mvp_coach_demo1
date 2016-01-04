package mvp.gjj.gjj_mvp_basedemo.present;

import android.content.Context;
import java.util.logging.Handler;

import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment1View;

/**
 * 作者：gjj on 2016/1/4 17:31
 * 邮箱：Gujj512@163.com
 */
public class Fragment1Present extends BasePresenter<Fragment1View> {
    private Context context;
    public Fragment1Present(Context context){
        this.context=context;
    }
    /**
     * 请求网络操作
     */
    public void loadData(boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().showContent();
            }
        }, 5000);
    }
}
