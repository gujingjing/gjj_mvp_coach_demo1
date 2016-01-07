package mvp.gjj.gjj_mvp_basedemo.present;

import android.content.Context;
import android.system.ErrnoException;

import java.util.ArrayList;
import java.util.List;

import mvp.gjj.androidbaselib.base.BaseApplication;
import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.model.LoginToken;
import mvp.gjj.gjj_mvp_basedemo.model.MainActivityModel;
import mvp.gjj.gjj_mvp_basedemo.retrofit.RetrofitManager;
import mvp.gjj.gjj_mvp_basedemo.view.MainActivityView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 作者：gjj on 2016/1/5 09:57
 * 邮箱：Gujj512@163.com
 */
public class MainActivityPresent extends BasePresenter<MainActivityView> {

    private Context context;
    public MainActivityPresent(Context context){
        this.context=context;
    }
    /**
     * 加载数据
     */
    public void loadData(final boolean pullToRefresh){
//        getView().showLoading(pullToRefresh);//viewPager不需要显示加载，加载部分有内部的fragment显示
//        new android.os.Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                getView().showError(new Throwable("fdfd"),pullToRefresh);
//                getView().showContent();
//            }
//        }, 3000);
        Observable<LoginToken>  observable=RetrofitManager.retrofitManager.getToken("13916539504","123456");
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<LoginToken>() {
            @Override
            public void onCompleted() {
//                getView().showLoading(pullToRefresh);//这是后台加载数据的,不需要刷新
            }

            @Override
            public void onError(Throwable e) {
//                getView().showError(e,pullToRefresh);
            }

            @Override
            public void onNext(LoginToken loginToken) {
                MainActivityModel model=new MainActivityModel();
                model.loginToken=loginToken;
                getView().setData(model);
                getView().showContent();
//                getView().showError(new Throwable("测试用的异常"),pullToRefresh);
            }
        });
    }

}
