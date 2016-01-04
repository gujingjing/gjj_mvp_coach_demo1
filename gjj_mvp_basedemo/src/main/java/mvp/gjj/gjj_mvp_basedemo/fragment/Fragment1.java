package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.FragmentModel;
import mvp.gjj.gjj_mvp_basedemo.present.Fragment1Present;
import mvp.gjj.gjj_mvp_basedemo.view.Fragment1View;

/**
 * 作者：gjj on 2016/1/4 17:43
 * 邮箱：Gujj512@163.com
 */
public class Fragment1 extends BaseFragment<SwipeRefreshLayout,List<FragmentModel>,Fragment1View,Fragment1Present>implements Fragment1View{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.countries_list, container, false);
    }

    @Override
    public Fragment1Present createPresenter() {
        return new Fragment1Present(getActivity());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
}
