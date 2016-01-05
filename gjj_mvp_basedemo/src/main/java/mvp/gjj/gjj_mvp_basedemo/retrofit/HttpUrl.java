package mvp.gjj.gjj_mvp_basedemo.retrofit;

/**
 * 作者：gjj on 2016/1/5 11:08
 * 邮箱：Gujj512@163.com
 */
public class HttpUrl {
    //- Base URL: 总是以 /结尾- @Url: 不要以 / 开头
    public static String BASE_AU = "Basic MzUzYjMwMmM0NDU3NGY1NjUwNDU2ODdlNTM0ZTdkNmE6Mjg2OTI0Njk3ZTYxNWE2NzJhNjQ2YTQ5MzU0NTY0NmM=";
    public final static String suffix = "-test";
    public final static String URL_HOST = "https://platform-api" + suffix + ".1yd.me/";//测试
    //    {{url}}/oauth/token  获取token
    public final static String SENDMESSAGE = "/api/sms_validate_codes";
}
