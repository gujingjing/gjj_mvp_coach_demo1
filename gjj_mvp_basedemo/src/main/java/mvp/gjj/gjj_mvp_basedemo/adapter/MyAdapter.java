package mvp.gjj.gjj_mvp_basedemo.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.RecyleModel;

/**
 * 作者：gjj on 2016/1/7 00:08
 * 邮箱：xjs250@163.com
 */
public class MyAdapter extends BaseAdapter {
    List<RecyleModel> list=new ArrayList<>();
    Activity context;

    public MyAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_recyleview_nomal, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTest.setText(list.get(position).text);
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_recyleview_nomal.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.profile_image)
        CircleImageView profileImage;
        @Bind(R.id.tv_test)
        TextView tvTest;
        @Bind(R.id.cardview)
        RelativeLayout cardview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public void replace(List<RecyleModel>mlist){
        list.clear();
        list.addAll(mlist);
        notifyDataSetChanged();
    }
}
