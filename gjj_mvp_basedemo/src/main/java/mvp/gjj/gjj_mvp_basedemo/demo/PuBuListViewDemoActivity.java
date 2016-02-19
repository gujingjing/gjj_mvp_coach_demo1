package mvp.gjj.gjj_mvp_basedemo.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.cjj.MaterialRefreshLayout;

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
 * 作者：gjj on 2016/1/7 15:39
 * 邮箱：Gujj512@163.com
 */
public class PuBuListViewDemoActivity extends BaseActivity<MaterialRefreshLayout, List<DemoModel>, DemoView, DemoPresent> implements DemoView {
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.contentView)
    MaterialRefreshLayout contentView;

    private Toolbar toolbar;
    private BaseRcvQuickAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_list);
        ButterKnife.bind(this);
        setToolBar();
        adapter=new BaseRcvQuickAdapter(this,R.layout.home_masonry_item) {
            @Override
            protected void convert(BaseRcvAdapterHelper helper, int position, Object item) {
                DemoModel demoModel=(DemoModel)item;
                helper.setText(R.id.masonry_item_title, demoModel.text);
//                helper.setImageUrl(PuBuListViewDemoActivity.this, R.id.masonry_item_img, demoModel.imageUrl);
//                helper.setImageResource(R.id.masonry_item_img,demoModel.imageId);
                //自己传入glid
                DrawableRequestBuilder builder= Glide.with(PuBuListViewDemoActivity.this).load(demoModel.imageId)
                        .placeholder(R.mipmap.ic_launcher)//加载中显示的图片
                        .error(R.mipmap.ic_launcher);//加载错误显示的图片;
//                        .transform(new GlideCircleTransform(mActivity))
//                        .into(ivMyHead);
                helper.setImageUrl(builder,R.id.masonry_item_img);
            }
        };
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        contentView.setLoadMore(false);
        loadData(false);
    }
    public void setToolBar(){
//        toolbar= (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("android-mvpDemo");
//        getSupportActionBar().setDisplayShowHomeEnabled(true);   //使左上角图标是否显示
        // 给左上角图标的左边加上一个返回的图标
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        presenter.loadImageId(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.finishRefreshLoadMore();
        contentView.finishRefresh();
    }
}
