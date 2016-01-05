package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.EmptyModel;
import mvp.gjj.gjj_mvp_basedemo.present.EmptyFragmentPresent;
import mvp.gjj.gjj_mvp_basedemo.view.EmptyFragmentView;

/**
 * 作者：gjj on 2016/1/5 16:51
 * 邮箱：Gujj512@163.com
 */
public class Fragment3 extends BaseFragment<TextView, EmptyModel, EmptyFragmentView, EmptyFragmentPresent> implements EmptyFragmentView {

    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.contentView)
    TextView contentView;
    private EmptyModel data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.empty_fragment, null);
        return inflater.inflate(R.layout.empty_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loadData(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public EmptyFragmentPresent createPresenter() {
        return new EmptyFragmentPresent();
    }

    @Override
    public void setData(EmptyModel data) {
        this.data = data;
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        ToastUtils.setToastShot(getActivity(), data.toString());
//        presenter.setTextView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
