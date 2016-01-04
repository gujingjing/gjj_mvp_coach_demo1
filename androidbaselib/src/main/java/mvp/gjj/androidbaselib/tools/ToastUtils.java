package mvp.gjj.androidbaselib.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：gjj on 2015/10/29 12:03
 * 邮箱：app@1yd.me
 */
public class ToastUtils {
    public static void setToastLong(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
    public static void setToastShot(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
