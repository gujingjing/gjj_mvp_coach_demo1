package mvp.gjj.androidbaselib.base;

import android.content.Context;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

/**
 * 作者：gjj on 2016/1/4 15:37
 * 邮箱：Gujj512@163.com
 * MvpLceViewStateFragment
 */
public abstract class BaseFragment<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceFragment<CV,M,V,P>implements MvpLceView<M>{
}
