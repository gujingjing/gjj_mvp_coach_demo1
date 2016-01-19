package mvp.gjj.gjj_mvp_basedemo.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/8/5.
 */
public class My_photo_bean implements Serializable {
    private int id;
    private String picture_name;//图片地址
    private int coach_id;//教练id
    private String name;//图片名称
    private int show_number;//图片de number

    private boolean is_id_card;//是否是身份证图片
    private boolean is_deleted;//是否删除

    /**
     * 添加错误信息de
     * @param user_id
     */
    public String errmsg;
    public String errcode;

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setShow_number(int show_number) {
        this.show_number = show_number;
    }

    public int getShow_number() {
        return show_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_id_card(boolean is_id_card) {
        this.is_id_card = is_id_card;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public int getId() {
        return id;
    }

    public String getPicture_name() {
        return picture_name;
    }


    public String getName() {
        return name;
    }

    public boolean is_id_card() {
        return is_id_card;
    }

    public boolean is_deleted() {
        return is_deleted;
    }

    public My_photo_bean() {
        super();
    }

    @Override
    public String toString() {
        return "My_photo_bean{" +
                "id=" + id +
                ", picture_name='" + picture_name + '\'' +
                ", coach_id=" + coach_id +
                ", name='" + name + '\'' +
                ", show_number=" + show_number +
                ", is_id_card=" + is_id_card +
                ", is_deleted=" + is_deleted +
                ", errmsg='" + errmsg + '\'' +
                ", errcode='" + errcode + '\'' +
                '}';
    }
}
