package mvp.gjj.androidbaselib.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import mvp.gjj.androidbaselib.R;
import mvp.gjj.androidbaselib.tools.NetWorkUtil;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.androidbaselib.view.finishClassView.SwipeBackLayout;

/**
 * 作者：gjj on 2016/1/4 14:40
 * 邮箱：Gujj512@163.com
 */
public abstract class BaseActivity <CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceActivity<CV,M,V,P> implements MvpLceView<M>{

        protected SwipeBackLayout layout;
        public BaseActivity context;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                context=this;
                if(finiActivity()){
                        //是否需要滑动消除界面的主要代码
                        layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                                R.layout.activity_base, null);
                        layout.attachToActivity(this);
                }

        }

        /**
         * 是否需要右滑删除界面
         */
        public abstract boolean finiActivity();
        @Override
        public void finish(){
                super.finish();
                overridePendingTransition(0, R.anim.base_slide_right_out);
        }
        @Override
        public void startActivity(Intent intent) {
                super.startActivity(intent);
                overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
        }
        // Press the back button in mobile phone
        @Override
        public void onBackPressed() {
                super.onBackPressed();
                overridePendingTransition(0, R.anim.base_slide_right_out);
        }
        /**
         * 当没有网络的时候
         */
        public void onDisConnect() {
                ToastUtils.setToastLong(context,"暂时没有网络,请稍后重试");
        }
        /**
         * 当网络连接的时候
         */
        public void onConnect(NetWorkUtil.NetType type){
                ToastUtils.setToastLong(context,"网络已经连接");
        }
}
