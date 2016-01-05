package mvp.gjj.androidbaselib.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * 作者：gjj on 2016/1/4 17:26
 * 邮箱：Gujj512@163.com
 * MvpNullObjectBasePresenter 设个比mvpBasePresenter好一点，解决了为空的异常
 */
public abstract class BasePresenter<V extends MvpView> extends MvpNullObjectBasePresenter<V> {

}
