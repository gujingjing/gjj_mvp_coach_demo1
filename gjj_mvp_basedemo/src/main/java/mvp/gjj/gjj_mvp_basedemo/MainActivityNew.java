package mvp.gjj.gjj_mvp_basedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseActivity;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.manager.AppManager;
import mvp.gjj.androidbaselib.netstate.NetworkStateReceiver;
import mvp.gjj.androidbaselib.tools.LogUtils;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.androidbaselib.view.MyViewPager;
import mvp.gjj.androidbaselib.view.viewpagerTools.CubeTransformer;
import mvp.gjj.androidbaselib.view.viewpagerTools.FixedSpeedScroller;
import mvp.gjj.androidbaselib.view.viewpagerTools.ZoomOutPageTransformer;
import mvp.gjj.gjj_mvp_basedemo.adapter.MainFragmentAdapter;
import mvp.gjj.gjj_mvp_basedemo.factory.FragmentFactory;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment1;
import mvp.gjj.gjj_mvp_basedemo.model.MainActivityModel;
import mvp.gjj.gjj_mvp_basedemo.present.MainActivityPresent;
import mvp.gjj.gjj_mvp_basedemo.view.MainActivityView;

/**
 * 作者：gjj on 2016/1/5 09:52
 * 邮箱：Gujj512@163.com
 */
public class MainActivityNew extends BaseActivity<MyViewPager, MainActivityModel, MainActivityView, MainActivityPresent> implements MainActivityView {

    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.contentView)
    MyViewPager viewpager;
    @Bind(R.id.me_0)
    RadioButton me0;
    @Bind(R.id.me_1)
    RadioButton me1;
    @Bind(R.id.me_2)
    RadioButton me2;
    @Bind(R.id.me_3)
    RadioButton me3;
    @Bind(R.id.main_select)
    RadioGroup mainSelect;
    @Bind(R.id.main_table_item)
    LinearLayout mainTableItem;
    private List<BaseFragment> fragments = new ArrayList<>();
    private MainFragmentAdapter adapter;
    FixedSpeedScroller mScroller = null;
    MainActivityModel data;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NetworkStateReceiver.registerNetworkStateReceiver(context);
        initFragment();
        adapter=new MainFragmentAdapter(getSupportFragmentManager(),fragments);

        viewpager.setOffscreenPageLimit(fragments.size());//设置每次缓存的次数
        viewpager.setPageTransformer(true, new ZoomOutPageTransformer());//设置viewpager翻页的动画
        controlViewPagerSpeed();//设置viewpager滑动速度
        viewpager.setAdapter(adapter);

        BaseFragment fragment = FragmentFactory.createFragment(0);
        //setCurrentItem第二个参数true,表示页面划过去,false 不划过去
        viewpager.setCurrentItem(0, true);
//        fragment.loadData(false);//点击了就重新显示数据
        //radioGroup设置点击事件
        mainSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) group.findViewById(id);
                String page = (String) rb.getTag();
                BaseFragment fragment = FragmentFactory.createFragment(Integer.parseInt(page));
                //setCurrentItem第二个参数true,表示页面划过去,false 不划过去
                viewpager.setCurrentItem(Integer.parseInt(page), true);
//                fragment.loadData(false);//点击了就重新显示数据
            }
        });
        loadData(false);
    }

    @NonNull
    @Override
    public MainActivityPresent createPresenter() {
        return new MainActivityPresent(context);
    }

    @Override
    public boolean finiActivity() {
        return false;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(MainActivityModel data) {
        this.data=data;
        ToastUtils.setToastLong(context,data.toString());
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        ToastUtils.setToastLong(context, "主界面显示");
//        LogUtils.e(data.toString());
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
//        ToastUtils.setToastLong(context, e.toString());
//        LogUtils.e(e.toString());
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
    }
    public void initFragment() {
        fragments.add(FragmentFactory.createFragment(0));
        fragments.add(FragmentFactory.createFragment(1));
        fragments.add(FragmentFactory.createFragment(2));
        fragments.add(FragmentFactory.createFragment(3));
    }
    /**
     * 设置viewPager滑动速度
     */
    private void controlViewPagerSpeed() {
        try {
            Field mField;
            mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            mScroller = new FixedSpeedScroller(viewpager.getContext(),
                    new AccelerateInterpolator());
            mScroller.setmDuration(400); // 400ms
            mField.set(viewpager, mScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                AppManager.getAppManager().AppExit(context);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetworkStateReceiver.unRegisterNetworkStateReceiver(context);
    }
}
