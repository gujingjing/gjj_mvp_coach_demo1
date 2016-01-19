package mvp.gjj.gjj_mvp_basedemo.retrofit;

import com.squareup.okhttp.RequestBody;

import mvp.gjj.gjj_mvp_basedemo.model.CoachBean;
import mvp.gjj.gjj_mvp_basedemo.model.Teach_exp_Prove_Bean;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import rx.Observable;

/**
 * 作者：gjj on 2015/12/1 11:35
 * 邮箱：Gujj512@163.com
 */
public interface WithTokenServices {
    //{{url}}/api/coach/award/picture/396
    //    在2.0中需要使用RequestBody代替TypedFile。得到文件RequestBody使用它在你的请求更多信息:https://github.com/square/retrofit/issues/1063
    @Multipart
    @POST("/api/coach/award/picture/{userId}")
    Observable<Teach_exp_Prove_Bean> upTeachProPicture(@Path("userId") String userId, @Part("file") RequestBody file);

    @GET("/api/coaches/current")//获取当前用户
    Observable<CoachBean> getUser();
}
