package mvp.gjj.androidbaselib.retrofit;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import mvp.gjj.androidbaselib.tools.LogUtils;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 作者：gjj on 2015/12/1 10:03
 * 邮箱：Gujj512@163.com
 */
public class RetrofitMaker {
    /**
     * 不设置token的api
     */
    public static <T> T creeatApi(Class<T> clazz, String baseUrl) {
        return creeatApi(clazz,baseUrl,"");
    }

    /**
     * 设置token的api
     */
    public static <T> T creeatApi(Class<T> clazz, String baseUrl, String token) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)//- Base URL: 总是以 /结尾- @Url: 不要以 / 开头
                //你也可以通过实现Converter.Factory接口来创建自己的转换器
                .addConverterFactory(GsonConverterFactory.create())//添加解析器-gson解析
                .client(initClient(token))//Retrofit 2.0上，OKHttp是必须
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//Service接口现在可以作为Observable返回了
                .build();
        return retrofit.create(clazz);
    }

    /**
     * 设置okHttp的初始化
     */
    public static OkHttpClient initClient(final String token) {
        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(new Interceptor() {//设置ok的头信息
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!token.equals("")) {
                    request=request.newBuilder().addHeader("Authorization", token).build();
                }
                LogUtils.e("requestUrl==="+request.urlString());//输出requestUrl
                LogUtils.e("requestHeader==="+request.headers().toString());//输出requestUrl
                LogUtils.e("requestBody==="+request.body());//输出request请求内容
                return chain.proceed(request);
            }
        });
        //TODO 以后可能添加session
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        });

        return client;
    }
}
