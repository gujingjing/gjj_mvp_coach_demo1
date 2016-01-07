package mvp.gjj.gjj_mvp_basedemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：gjj on 2016/1/7 13:45
 * 邮箱：Gujj512@163.com
 */
public class DemoModel implements Parcelable {
    public String text;
    public String imageUrl;
    public int imageId;
    public DemoModel(String text,String imageUrl){
        this.text=text;
        this.imageUrl=imageUrl;
    }
    public DemoModel(int imageId,String text){
        this.text=text;
        this.imageId=imageId;
    }
    @Override
    public String toString() {
        return "DemoModel{" +
                "text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageId=" + imageId +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeString(this.imageUrl);
        dest.writeInt(this.imageId);
    }

    protected DemoModel(Parcel in) {
        this.text = in.readString();
        this.imageUrl = in.readString();
        this.imageId = in.readInt();
    }

    public static final Parcelable.Creator<DemoModel> CREATOR = new Parcelable.Creator<DemoModel>() {
        public DemoModel createFromParcel(Parcel source) {
            return new DemoModel(source);
        }

        public DemoModel[] newArray(int size) {
            return new DemoModel[size];
        }
    };
}
