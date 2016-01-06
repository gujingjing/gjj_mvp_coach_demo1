package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.adapter.MyAdapter;
import mvp.gjj.gjj_mvp_basedemo.adapter.RecyleViewNomalAdapter;
import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.OnItemClickListener;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;
import mvp.gjj.gjj_mvp_basedemo.present.Fragment1Present;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment1View;

/**
 * 作者：gjj on 2016/1/4 17:43
 * 邮箱：Gujj512@163.com
 */
public class Fragment1_Copy extends BaseFragment<ListView, List<RecyleModel>, Fragment1View, Fragment1Present> implements Fragment1View {
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.contentView)
    ListView contentView;

    private MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_copy, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new MyAdapter(getActivity());
        contentView.setAdapter(adapter);
        loadData(false);//第一次显示数据
    }

    @Override
    public Fragment1Present createPresenter() {
        return new Fragment1Present(getActivity());
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(List<RecyleModel> data) {
        adapter.replace(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();

    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
