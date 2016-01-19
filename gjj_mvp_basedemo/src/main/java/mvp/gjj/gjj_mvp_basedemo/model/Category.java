package mvp.gjj.gjj_mvp_basedemo.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/17.
 */
public class Category implements Serializable {

    /**
     * category_name : 网球
     * category_id : 1
     */
    public String category_name;
    public int category_id;

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    /**
     * 添加错误信息de
     * @param user_id
     */
    public String errmsg;
    public String errcode;

    @Override
    public String toString() {
        return "Category{" +
                "category_name='" + category_name + '\'' +
                ", category_id=" + category_id +
                ", errmsg='" + errmsg + '\'' +
                ", errcode='" + errcode + '\'' +
                '}';
    }
}
