package mvp.gjj.gjj_mvp_basedemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.gjj.androidbaselib.base.BaseFragment;
import mvp.gjj.androidbaselib.tools.LogUtils;
import mvp.gjj.androidbaselib.tools.ToastUtils;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.CoachBean;
import mvp.gjj.gjj_mvp_basedemo.model.EmptyModel;
import mvp.gjj.gjj_mvp_basedemo.model.LoginToken;
import mvp.gjj.gjj_mvp_basedemo.present.EmptyFragmentPresent;
import mvp.gjj.gjj_mvp_basedemo.view.EmptyFragmentView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 作者：gjj on 2016/1/5 16:51
 * 邮箱：Gujj512@163.com
 */
public class Fragment3 extends BaseFragment<LinearLayout, EmptyModel, EmptyFragmentView, EmptyFragmentPresent> implements EmptyFragmentView {

    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.contentView)
    LinearLayout contentView;
    @Bind(R.id.tv_text)
    TextView tvText;
    @Bind(R.id.btn_btntest)
    Button btnBtntest;

    private EmptyModel data;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.empty_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
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
//        ToastUtils.setToastShot(getActivity(), data.toString());
//        presenter.setTextView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    @OnClick({R.id.btn_btntest})void onclick(View view){
        switch (view.getId()){
            case R.id.btn_btntest://测试
                presenter.upPicture();
                presenter.login("13916539504","123456")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<CoachBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                LogUtils.e(e.toString());
                                ToastUtils.setToastLong(getActivity(),"获取当前对象失败");
                            }

                            @Override
                            public void onNext(CoachBean coachBean) {
                                LogUtils.e(coachBean.toString());
                                ToastUtils.setToastLong(getActivity(),"获取当前对象成功");
                            }
                        });
                break;
        }
    }
}
