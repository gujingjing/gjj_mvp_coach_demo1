package mvp.gjj.gjj_mvp_basedemo.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.BaseAdapter;
import mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter.BaseViewHolder;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;

/**
 * 作者：gjj on 2016/1/6 17:29
 * 邮箱：Gujj512@163.com
 */
public class RecyleViewNomalAdapter extends BaseAdapter<RecyleModel> {
    public RequestManager requestManager;
    public RecyleViewNomalAdapter(Activity mContext) {
        super(mContext);
        this.mContext = mContext;
        requestManager = Glide.with(mContext);
    }

    @Override
    public void onViewShow(BaseViewHolder viewHolde, int i, List<RecyleModel> mItemDataList) {
        ViewHolder viewHolder=(ViewHolder)viewHolde;
        viewHolder.textView.setText(mItemDataList.get(i).text);
//        requestManager.load("")
//                .placeholder(R.mipmap.head1)//加载中显示的图片
////                .error(R.mipmap.head1)//加载错误显示的图片;
////                .transform(new GlideCircleTransform(mActivity))
//                .into(viewHolder.profileImage);
    }

    @Override
    public BaseViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public int getLayout() {
        return R.layout.item_recyleview;
//        return R.layout.item_recyleview_nomal;

    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_recyleview.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder extends BaseViewHolder{
        @Bind(R.id.profile_image)
        CircleImageView profileImage;
        @Bind(R.id.tv_test)
        TextView textView;
        @Bind(R.id.cardview)
        CardView cardview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

//    static class ViewHolder extends BaseViewHolder{
//        @Bind(R.id.profile_image)
//        CircleImageView profileImage;
//        @Bind(R.id.tv_test)
//        TextView textView;
//        @Bind(R.id.cardview)
//        RelativeLayout cardview;
//
//        ViewHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }
}
