package mvp.gjj.gjj_mvp_basedemo.present;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;
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
                List<RecyleModel>list=new ArrayList<RecyleModel>();
                for (int i=0;i<20;i++){
                    list.add(new RecyleModel("测试用的文字","http://pic14.nipic.com/20110522/7411759_164157418126_2.jpg"));
                }
                getView().setData(list);
                getView().showContent();
            }
        }, 3000);
    }
    public void refreshView(boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                ToastUtils.setToastShot(context,"刷新数据成功");
                getView().showContent();
            }
        }, 3000);
    }
}
