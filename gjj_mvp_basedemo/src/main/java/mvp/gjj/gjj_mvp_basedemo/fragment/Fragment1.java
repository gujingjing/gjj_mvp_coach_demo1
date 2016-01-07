package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.adapter.RecyleViewNomalAdapter;
import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.OnItemClickListener;
import mvp.gjj.gjj_mvp_basedemo.model.FragmentModel;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;
import mvp.gjj.gjj_mvp_basedemo.present.Fragment1Present;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment1View;

/**
 * 作者：gjj on 2016/1/4 17:43
 * 邮箱：Gujj512@163.com
 */
public class Fragment1 extends BaseFragment<MaterialRefreshLayout, List<RecyleModel>, Fragment1View, Fragment1Present> implements Fragment1View {
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.contentView)
    MaterialRefreshLayout contentView;

    private RecyleViewNomalAdapter adapter;
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
        contentView.setLoadMore(true);
        adapter=new RecyleViewNomalAdapter(getActivity());
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
//        manager.setOrientation(OrientationHelper.HORIZONTAL);

        //gridView--manager第二个参数表示一共有几行
//        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 4);
        //mGridLayoutManager.setOrientation(OrientationHelper.VERTICAL);

        //StaggeredGridLayoutManager--namager  可以设置为瀑布流效果
//        StaggeredGridLayoutManager mStaggeredGridLayout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        setDivider();//设置recyleView分割线
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
//                ToastUtils.setToastShot(getActivity(), "第" + position + "个item");
            }
        });
        contentView.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.refreshView(true);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                presenter.refreshView(true);
            }
        });
        loadData(false);//第一次显示数据
    }

    public void setDivider(){
        Paint paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity())
                .paint(paint)
                .build());
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
        adapter.replaceAllData(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.finishRefresh();
        contentView.finishRefreshLoadMore();
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
