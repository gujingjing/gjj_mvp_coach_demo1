package mvp.gjj.gjj_mvp_basedemo.recycler;

import android.content.Context;
import android.support.annotation.LayoutRes;

import java.util.List;


/**
 * Created by HanHailong on 15/9/6.
 */
public abstract class QuickRcvAdapter<T> extends BaseRcvQuickAdapter<T, BaseRcvAdapterHelper> {

    /**
     * Create a QuickAdapter.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public QuickRcvAdapter(Context context, @LayoutRes int layoutResId) {
        super(context, layoutResId);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public QuickRcvAdapter(Context context, @LayoutRes int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    /**
     * Create a multi-view-type QuickAdapter
     *
     * @param context              The context
     * @param multiItemTypeSupport multiitemtypesupport
     */
    protected QuickRcvAdapter(Context context, MultiItemRcvTypeSupport<T> multiItemTypeSupport) {
        super(context, multiItemTypeSupport);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,MultiItemTypeSupport) but with
     * some initialization data
     *
     * @param context
     * @param multiItemTypeSupport
     * @param data
     */
    protected QuickRcvAdapter(Context context, MultiItemRcvTypeSupport<T> multiItemTypeSupport, List<T> data) {
        super(context, multiItemTypeSupport, data);
    }

}
