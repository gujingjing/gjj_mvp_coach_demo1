package mvp.gjj.gjj_mvp_basedemo.adapter.recyleViewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：lg on 2015-10-31 16:39
 * 邮箱：support@1yd.me
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private View contentView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.contentView=itemView;
    }
    public View getView(){
        return contentView;
    }
}
