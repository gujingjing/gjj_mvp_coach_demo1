package mvp.gjj.gjj_mvp_basedemo.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseActivity;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.DemoModel;
import mvp.gjj.gjj_mvp_basedemo.present.DemoPresent;
import mvp.gjj.gjj_mvp_basedemo.recycler.BaseRcvAdapterHelper;
import mvp.gjj.gjj_mvp_basedemo.recycler.BaseRcvQuickAdapter;
import mvp.gjj.gjj_mvp_basedemo.view.DemoView;

/**
 * 作者：gjj on 2016/1/7 11:55
 * 邮箱：Gujj512@163.com
 */
public class StagListViewDemoActivity extends BaseActivity<MaterialRefreshLayout, List<DemoModel>, DemoView, DemoPresent> implements DemoView {

    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.contentView)
    MaterialRefreshLayout contentView;

    private BaseRcvQuickAdapter adapter;
    private List<DemoModel>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_list);
        ButterKnife.bind(this);

        adapter=new BaseRcvQuickAdapter(this,R.layout.item_recyleview) {
            @Override
            protected void convert(BaseRcvAdapterHelper helper, int position, Object item) {
                DemoModel demoModel=(DemoModel)item;
                helper.setText(R.id.tv_test,demoModel.text);
                helper.setImageUrl(StagListViewDemoActivity.this, R.id.profile_image, demoModel.imageUrl);
            }
        };
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        contentView.setLoadMore(false);
        loadData(false);
    }

    @Override
    public boolean finiActivity() {
        return true;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @NonNull
    @Override
    public DemoPresent createPresenter() {
        return new DemoPresent();
    }

    @Override
    public void setData(List<DemoModel> data) {
        adapter.replaceAll(data);
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
}
