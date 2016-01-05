package mvp.gjj.gjj_mvp_basedemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：gjj on 2016/1/5 16:51
 * 邮箱：Gujj512@163.com
 */
public class EmptyModel implements Parcelable {
    public String message;

    @Override
    public String toString() {
        return "EmptyModel{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
    }

    public EmptyModel() {
    }

    protected EmptyModel(Parcel in) {
        this.message = in.readString();
    }

    public static final Parcelable.Creator<EmptyModel> CREATOR = new Parcelable.Creator<EmptyModel>() {
        public EmptyModel createFromParcel(Parcel source) {
            return new EmptyModel(source);
        }

        public EmptyModel[] newArray(int size) {
            return new EmptyModel[size];
        }
    };
}
