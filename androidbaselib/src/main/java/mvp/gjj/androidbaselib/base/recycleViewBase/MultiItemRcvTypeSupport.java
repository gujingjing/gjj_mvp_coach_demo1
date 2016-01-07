package mvp.gjj.androidbaselib.base.recycleViewBase;

public interface MultiItemRcvTypeSupport<T> {

    int getLayoutId(int viewType);

    int getItemViewType(int position, T t);

}