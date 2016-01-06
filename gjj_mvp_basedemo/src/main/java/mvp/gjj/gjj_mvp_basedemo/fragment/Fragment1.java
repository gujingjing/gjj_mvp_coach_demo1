package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.FragmentModel;
import mvp.gjj.gjj_mvp_basedemo.present.Fragment1Present;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment1View;

/**
 * 作者：gjj on 2016/1/4 17:43
 * 邮箱：Gujj512@163.com
 */
public class Fragment1 extends BaseFragment<MaterialRefreshLayout, List<FragmentModel>, Fragment1View, Fragment1Present> implements Fragment1View {
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.contentView)
    MaterialRefreshLayout contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.countries_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRefresh();
        loadData(false);//第一次显示数据
    }

    public void initRefresh() {
        initRecyleViewRefresh();
        initMatrRefresh();
    }
    public void initRecyleViewRefresh(){
        /**recelview的设置*/
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);


    }
    public void initMatrRefresh(){
        /**MaterialRefreshLayout的设置*/
        contentView.setLoadMore(true);//是否允许加载更多
        contentView.finishRefreshLoadMore();
        contentView.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {//下拉
                presenter.refreshView();
            }
            @Override
            public void onfinish() {//关闭刷新状态
                super.onfinish();
                contentView.finishRefresh();
                contentView.finishRefreshLoadMore();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {//加载更多
                super.onRefreshLoadMore(materialRefreshLayout);
                presenter.refreshView();
            }
        });
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
    public void setData(List<FragmentModel> data) {

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
