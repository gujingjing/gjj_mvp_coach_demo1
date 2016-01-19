package mvp.gjj.gjj_mvp_basedemo.retrofit;

import com.squareup.okhttp.RequestBody;

import mvp.gjj.androidbaselib.retrofit.RetrofitMaker;
import mvp.gjj.androidbaselib.tools.LogUtils;
import mvp.gjj.gjj_mvp_basedemo.model.CoachBean;
import mvp.gjj.gjj_mvp_basedemo.model.LoginToken;
import mvp.gjj.gjj_mvp_basedemo.model.Teach_exp_Prove_Bean;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 作者：gjj on 2016/1/5 11:15
 * 邮箱：Gujj512@163.com
 */
public class RetrofitManager {
    public static RetrofitManager retrofitManager=new RetrofitManager();
    public static CoachBean coachBean;
    //登录获取token
    public LoginServices loginServices=RetrofitMaker.creeatApi(LoginServices.class,HttpUrl.URL_HOST,HttpUrl.BASE_AU);
    //带token的请求
    public WithTokenServices withTokenServices;
    //不带token的请求
    public NoTokenServices noTokenServices=RetrofitMaker.creeatApi(NoTokenServices.class, HttpUrl.URL_HOST);
    /**
     * 登录获取token
     */
    public Observable getToken(String userName,String pwd){
        return loginServices.getToken(userName,pwd,"password");
    }
    /**
     * 登录
     */
    public Observable<CoachBean> login(String userName,String pwd){

        return getToken(userName,pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<LoginToken, Observable<CoachBean>>() {
            @Override
            public Observable<CoachBean> call(LoginToken loginToken) {
                LogUtils.e(loginToken.token_type + " " + loginToken.access_token);
                withTokenServices=RetrofitMaker.creeatApi(WithTokenServices.class,HttpUrl.URL_HOST,loginToken.token_type + " " + loginToken.access_token);
                return withTokenServices.getUser();
            }
        });
    }
    /**
     * RequestBody file = RequestBody.create(MediaType.parse("image/*"), path);
     */
    public Observable<Teach_exp_Prove_Bean> upTeachProPicture(String urerId,RequestBody file){
        //680为测试使用的
        return withTokenServices.upTeachProPicture("680",file);
    }
}
