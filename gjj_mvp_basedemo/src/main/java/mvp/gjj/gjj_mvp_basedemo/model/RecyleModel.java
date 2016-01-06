package mvp.gjj.gjj_mvp_basedemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：gjj on 2016/1/6 17:34
 * 邮箱：Gujj512@163.com
 */
public class RecyleModel implements Parcelable {
    public String text;
    public String imageUrl;

    @Override
    public String toString() {
        return "RecyleModel{" +
                "text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
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
    }

    public RecyleModel() {
    }
    public RecyleModel(String text,String imageUrl) {
        this.text=text;
        this.imageUrl=imageUrl;
    }
    protected RecyleModel(Parcel in) {
        this.text = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<RecyleModel> CREATOR = new Parcelable.Creator<RecyleModel>() {
        public RecyleModel createFromParcel(Parcel source) {
            return new RecyleModel(source);
        }

        public RecyleModel[] newArray(int size) {
            return new RecyleModel[size];
        }
    };
}
