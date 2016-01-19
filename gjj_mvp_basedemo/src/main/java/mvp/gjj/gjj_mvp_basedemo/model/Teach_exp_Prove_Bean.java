package mvp.gjj.gjj_mvp_basedemo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 教练资质图片 on 2015/8/19.
 */
public class Teach_exp_Prove_Bean implements Serializable{

    /**
     * id : 4
     * new : false
     * awardID : null
     * awardPicture : coach-317f79e3-88bd-4616-8fe8-7a33a1316c1f.jpeg
     * creationTime : 1440122056655
     * deleted : false
     */
    public int id;
    @SerializedName("new")
    public boolean newX;
    public String awardID;
    public String awardPicture;
    public long creationTime;
    public boolean deleted;

    @Override
    public String toString() {
        return "Teach_exp_Prove_Bean{" +
                "id=" + id +
                ", newX=" + newX +
                ", awardID='" + awardID + '\'' +
                ", awardPicture='" + awardPicture + '\'' +
                ", creationTime=" + creationTime +
                ", deleted=" + deleted +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

    public void setAwardID(String awardID) {
        this.awardID = awardID;
    }

    public void setAwardPicture(String awardPicture) {
        this.awardPicture = awardPicture;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public boolean isNewX() {
        return newX;
    }

    public String getAwardID() {
        return awardID;
    }

    public String getAwardPicture() {
        return awardPicture;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
