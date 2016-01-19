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
        client.networkInterceptors().add(new NetWorkInterceptor(token));
        //   设置cookie     http://blog.csdn.net/sbsujjbcy/article/details/46895039
        //        client.setCookieHandler()
        return client;
    }
}
