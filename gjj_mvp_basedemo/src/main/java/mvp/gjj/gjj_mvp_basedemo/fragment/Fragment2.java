package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.FragmentModel;
import mvp.gjj.gjj_mvp_basedemo.present.Fragment2Present;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment2View;

/**
 * 作者：gjj on 2016/1/4 22:36
 * 邮箱：xjs250@163.com
 */
public class Fragment2 extends BaseFragment<TextView, List<FragmentModel>, Fragment2View, Fragment2Present> implements Fragment2View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.empt, container);
    }

    @Override
    public Fragment2Present createPresenter() {
        return new Fragment2Present();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(List<FragmentModel> data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        ToastUtils.setToastLong(getActivity(), "数据加载成功----");
//        presenter.setTextview(tvTest,"dsfsfds");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
