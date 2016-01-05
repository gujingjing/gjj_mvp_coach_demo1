package mvp.gjj.gjj_mvp_basedemo.present;

import android.widget.TextView;

import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.gjj_mvp_basedemo.model.EmptyModel;
import mvp.gjj.gjj_mvp_basedemo.view.EmptyFragmentView;

/**
 * 作者：gjj on 2016/1/5 16:53
 * 邮箱：Gujj512@163.com
 */
public class EmptyFragmentPresent extends BasePresenter<EmptyFragmentView> {

    public EmptyFragmentPresent(){

    }
    /**
     * 加载数据
     */
    public void loadData(boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                EmptyModel emptyModel=new EmptyModel();
                emptyModel.message="这是一个fragment";
                getView().setData(emptyModel);
                getView().showContent();
            }
        },3000);
    }
    /**
     * 设置textview
     */
    public void setTextView(TextView textView,EmptyModel emptyModel){
        textView.setText(emptyModel.toString());
    }
}
