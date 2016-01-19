package mvp.gjj.androidbaselib.retrofit;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import mvp.gjj.androidbaselib.tools.LogUtils;

/**
 * 作者：gjj on 2016/1/18 13:36
 * 邮箱：Gujj512@163.com
 * 网络拦截器-设置请求头
 */
public class NetWorkInterceptor implements Interceptor {
    private String token="";
    public NetWorkInterceptor(){

    }
    public NetWorkInterceptor(String token){
        this.token=token;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!token.equals("")) {
            request=request.newBuilder().addHeader("Authorization", token).build();
        }
        LogUtils.e("requestUrl==="+request.urlString());//输出requestUrl
        LogUtils.e("requestHeader==="+request.headers().toString());//输出requestUrl
        LogUtils.e("requestBody==="+request.body());//输出request请求内容

        Response response=chain.proceed(request);
        return response;
    }
}
