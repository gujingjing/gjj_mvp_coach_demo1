package mvp.gjj.gjj_mvp_basedemo.retrofit;

import android.util.TypedValue;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.Part;
import retrofit.http.Path;
import rx.Observable;

/**
 * 作者：gjj on 2015/12/1 11:35
 * 邮箱：Gujj512@163.com
 */
public interface NoTokenServices {
    @Multipart
    @GET("http://img1.imgtn.bdimg.com/it/u=1768261506,2972859401&fm=21&gp=0.jpg")// 2.0中我们还可以在@Url里面定义完整的URL：
    Observable<Object> getPicture(@Part("file") TypedValue file);
}
