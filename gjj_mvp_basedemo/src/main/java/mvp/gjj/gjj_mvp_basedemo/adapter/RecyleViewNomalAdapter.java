package mvp.gjj.gjj_mvp_basedemo.adapter;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.BaseAdapter;
import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.BaseViewHolder;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;

/**
 * 作者：gjj on 2016/1/6 17:29
 * 邮箱：Gujj512@163.com
 */
public class RecyleViewNomalAdapter extends BaseAdapter<RecyleModel>{
    public RecyleViewNomalAdapter(Activity mContext) {
        super(mContext);
        this.mContext=mContext;
    }

    @Override
    public void onViewShow(BaseViewHolder viewHolder, int i, List<RecyleModel> mItemDataList) {

    }

    @Override
    public BaseViewHolder createViewHolder(View view) {
        return null;
    }

    @Override
    public int getLayout() {
        return 0;
    }
}
