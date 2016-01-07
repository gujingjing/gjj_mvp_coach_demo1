package mvp.gjj.gjj_mvp_basedemo.present;

import java.util.ArrayList;
import java.util.List;

import mvp.gjj.androidbaselib.base.BasePresenter;
import mvp.gjj.gjj_mvp_basedemo.R;
import mvp.gjj.gjj_mvp_basedemo.model.DemoModel;
import mvp.gjj.gjj_mvp_basedemo.view.DemoView;

/**
 * 作者：gjj on 2016/1/7 13:48
 * 邮箱：Gujj512@163.com
 */
public class DemoPresent extends BasePresenter<DemoView> {

    public void loadData(boolean pullToRefresh) {
        getView().showLoading(pullToRefresh);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<DemoModel>list=new ArrayList<DemoModel>();
                for (int i=0;i<3;i++){
                    list.add(new DemoModel("测试用的文字","http://pic14.nipic.com/20110522/7411759_164157418126_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://baike.soso.com/p/20090711/20090711101754-314944703.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://img2.3lian.com/img2007/19/33/005.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pica.nipic.com/2007-11-09/200711912453162_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pica.nipic.com/2008-03-19/2008319183523380_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://img4.3lian.com/sucai/img6/230/29.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://a2.att.hudong.com/38/59/300001054794129041591416974.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pic1.nipic.com/2008-09-12/20089129255891_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pic.nipic.com/2007-11-08/2007118192149610_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://pic.nipic.com/2007-11-09/2007119123053767_2.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://img3.imgtn.bdimg.com/it/u=2471132592,1969231645&fm=21&gp=0.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://img2.niutuku.com/desk/anime/3354/3354-4958.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://imgsrc.baidu.com/forum/pic/item/7669d5628535e5ddab84941c76c6a7efcc1b62f7.jpg"));
                    list.add(new DemoModel("测试用的文字", "http://image.xinmin.cn/2012/07/04/20120704102330693834.jpg"));
                }
                getView().setData(list);
                getView().showContent();
            }
        },3000);
    }
    public void loadImageId(boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<DemoModel>list=new ArrayList<DemoModel>();
                initData(list);
                getView().setData(list);
                getView().showContent();
            }
        },3000);
    }
    private void initData(List<DemoModel>productList) {
        DemoModel p1=new DemoModel(R.mipmap.p1,"我是照片1");
        productList.add(p1);
        DemoModel p2=new DemoModel(R.mipmap.p2,"我是照片2");
        productList.add(p2);
        DemoModel p3=new DemoModel(R.mipmap.p3,"我是照片3");
        productList.add(p3);
        DemoModel p4=new DemoModel(R.mipmap.p4,"我是照片4");
        productList.add(p4);
        DemoModel p5=new DemoModel(R.mipmap.p5,"我是照片5");
        productList.add(p5);
        DemoModel p6=new DemoModel(R.mipmap.p6,"我是照片6");
        productList.add(p6);
        DemoModel p7=new DemoModel(R.mipmap.p2,"我是照片7");
        productList.add(p7);
        DemoModel p8=new DemoModel(R.mipmap.p1,"我是照片8");
        productList.add(p8);
        DemoModel p9=new DemoModel(R.mipmap.p4,"我是照片9");
        productList.add(p9);
        DemoModel p10=new DemoModel(R.mipmap.p6,"我是照片10");
        productList.add(p10);
        DemoModel p11=new DemoModel(R.mipmap.p3,"我是照片11");
        productList.add(p11);
    }
}
