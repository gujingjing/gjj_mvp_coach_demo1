package mvp.gjj.gjj_mvp_basedemo.present;

import android.widget.TextView;

import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment2View;

/**
 * 作者：gjj on 2016/1/4 22:37
 * 邮箱：xjs250@163.com
 */
public class Fragment2Present extends BasePresenter<Fragment2View> {
    public Fragment2Present(){

    }
    /**
     * 网络请求操作
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
    /**
     * 显示textview
     */
    public void setTextview(TextView textview,String string){
        textview.setText(string==null?"":string);
    }

}
