package mvp.gjj.gjj_mvp_basedemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：gjj on 2016/1/5 09:52
 * 邮箱：Gujj512@163.com
 */
public class MainActivityModel implements Parcelable {
    public LoginToken loginToken;

    @Override
    public String toString() {
        return "MainActivityModel{" +
                "loginToken=" + loginToken +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.loginToken);
    }

    public MainActivityModel() {
    }

    protected MainActivityModel(Parcel in) {
        this.loginToken = (LoginToken) in.readSerializable();
    }

    public static final Parcelable.Creator<MainActivityModel> CREATOR = new Parcelable.Creator<MainActivityModel>() {
        public MainActivityModel createFromParcel(Parcel source) {
            return new MainActivityModel(source);
        }

        public MainActivityModel[] newArray(int size) {
            return new MainActivityModel[size];
        }
    };
}
