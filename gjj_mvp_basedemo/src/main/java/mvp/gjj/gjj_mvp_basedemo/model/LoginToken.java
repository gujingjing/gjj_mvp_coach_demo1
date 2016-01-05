package mvp.gjj.gjj_mvp_basedemo.model;

import java.io.Serializable;

/**
 * 作者：lg on 2015-10-28 14:32
 * 邮箱：support@1yd.me
 */
public class LoginToken implements Serializable {
    public String access_token;
    public String token_type;


    @Override
    public String toString() {
        return "LoginToken{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                '}';
    }
}
