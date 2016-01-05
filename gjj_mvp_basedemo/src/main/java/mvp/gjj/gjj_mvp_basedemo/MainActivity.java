package mvp.gjj.gjj_mvp_basedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.view.MyViewPager;
import mvp.gjj.androidbaselib.view.viewpagerTools.CubeTransformer;
import mvp.gjj.androidbaselib.view.viewpagerTools.FixedSpeedScroller;
import mvp.gjj.gjj_mvp_basedemo.adapter.MainFragmentAdapter;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment1;
import mvp.gjj.gjj_mvp_basedemo.fragment.Fragment2;

public class MainActivity extends AppCompatActivity {

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
    private List<BaseFragment> fragments=new ArrayList<>();
    private MainFragmentAdapter adapter;
    FixedSpeedScroller mScroller = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        adapter=new MainFragmentAdapter(getSupportFragmentManager(),fragments);

        viewpager.setOffscreenPageLimit(fragments.size());//设置每次缓存的次数
        viewpager.setPageTransformer(true, new CubeTransformer());//设置viewpager翻页的动画
//        viewpager.setPageTransformer(true, new ZoomOutPageTransformer());
        controlViewPagerSpeed();//设置viewpager滑动速度

        viewpager.setAdapter(adapter);

        //radioGroup设置点击事件
        mainSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) group.findViewById(id);
                String page = (String) rb.getTag();
                //setCurrentItem第二个参数true,表示页面划过去,false 不划过去
                viewpager.setCurrentItem(Integer.parseInt(page), false);
                fragments.get(Integer.parseInt(page)).loadData(false);//点击了就重新显示数据
            }
        });
    }

    public void initFragment() {
        fragments.add(new Fragment1());
        fragments.add(new Fragment1());
        fragments.add(new Fragment1());
        fragments.add(new Fragment1());
//        for (int i=0;i<3;i++){
//            Fragment2 fragment2=new Fragment2();
////            Bundle bundle=new Bundle();
////            bundle.putString("content", "这是第---"+(i + 1) + "---个fragment");
////            fragment2.setArguments(bundle);
//            fragments.add(fragment2);
//        }
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
}
