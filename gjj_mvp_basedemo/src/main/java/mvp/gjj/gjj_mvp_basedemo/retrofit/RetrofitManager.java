package mvp.gjj.gjj_mvp_basedemo.retrofit;

import mvp.gjj.androidbaselib.retrofit.RetrofitMaker;
import rx.Observable;

/**
 * 作者：gjj on 2016/1/5 11:15
 * 邮箱：Gujj512@163.com
 */
public class RetrofitManager {
    public static RetrofitManager retrofitManager=new RetrofitManager();
    //登录获取token
    public LoginServices loginServices=RetrofitMaker.creeatApi(LoginServices.class,HttpUrl.URL_HOST,HttpUrl.BASE_AU);
    //带token的请求
    public WithTokenServices withTokenServices= RetrofitMaker.creeatApi(WithTokenServices.class, HttpUrl.URL_HOST, HttpUrl.BASE_AU);

    /**
     * 登录获取token
     */
    public Observable getToken(String userName,String pwd){
        return loginServices.getToken(userName,pwd,"password");
    }
}
