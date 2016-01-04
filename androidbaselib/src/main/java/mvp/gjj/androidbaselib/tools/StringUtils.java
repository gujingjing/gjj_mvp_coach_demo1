package mvp.gjj.androidbaselib.tools;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 系统版本名称AppVersionName
     */
    public static String getAppVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 5);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo.versionName;
    }
    /**
     * 系统版本编码AppVersionCode
     */
    public static int getAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 5);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo.versionCode;
    }

    /**
     * 字符串为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }

    /**
     * 字符串不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    /**
     * 通过id获取对应的string
     */
    public static String getStringById(Context context, Integer id) {
        return context.getResources().getString(id);
    }


    /**
     * 拼接字符串
     *
     * @param straStrt
     * @param endStr
     * @return
     */
    public static String joinString(String straStrt, String connector,
                                    String endStr) {
        return new StringBuffer(straStrt).append(connector).append(endStr)
                .toString();
    }

    /**
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 隐藏键盘
     *
     * @param context
     */
    public static void hideInputMethod(Context context) {
        // TODO Auto-generated method stub
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            // 显示或者隐藏输入法
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 判断填的是不是数字或小数点
     */
    public static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+.*[0-9]*");
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
//            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是大是整数
     */
    public static boolean isLong(String value) {
        try {
//            Integer.parseInt(value);
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 手机号码校验
     */
    public static boolean isMobilePhone(String mobiles) {
        Pattern p = Pattern.compile("^0?1[3458]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 网址校验
     */
    public static boolean isHttp(String mobiles) {
        Pattern p = Pattern
                .compile("^http://[\\w-\\.]+(?:/|(?:/[\\w\\.\\-]+)*(?:/[\\w\\.\\-]+\\.do))?$");
        Matcher m = p.matcher(mobiles);

        Pattern p1 = Pattern
                .compile("^https://[\\w-\\.]+(?:/|(?:/[\\w\\.\\-]+)*(?:/[\\w\\.\\-]+\\.do))?$");
        Matcher m1 = p1.matcher(mobiles);
        return m.matches() || m1.matches();
    }

    /**
     * 固定电话，传真校验
     */
    public static boolean isFixMobilePhone(String mobiles) {
        // Pattern p = Pattern.compile("^(010|02\\d|0[3-9]\\d{2})?\\d{6,8}$");
        // Pattern p = Pattern.compile("^([0-9]{3,4}-)?[0-9]{7,8}$");
//		Pattern p = Pattern.compile("^((0\\d{2,3}-\\d{7,8})|(1[3584]\\d{9}))$");
        Pattern p = Pattern.compile("^((\\d{3,4})|\\d{3,4}-)?\\d{7,8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断邮编
     *
     * @param zipString
     * @return
     */
    public static boolean isZipNO(String zipString) {
        String str = "^[0-9]{6}$";
        return Pattern.compile(str).matcher(zipString).matches();
    }

    /**
     * 判断邮箱是否合法
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (null == email || "".equals(email))
            return false;
        // Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * //此方法，如果显示则隐藏，如果隐藏则显示
     *
     * @param activity
     */
    public static void hideInputMethod(Activity activity) {
        // TODO Auto-generated method stub
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            // 显示或者隐藏输入法
//            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    // InputMethodManager imm =
    // (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    // boolean isOpen=imm.isActive();
    // isOpen若返回true，则表示输入法打开

    /**
     * 安装apk
     */
    public static void install_Apk(File file, Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }

    /**
     * 判断是否是int
     *
     * @param value
     * @return
     */
    public static boolean isValidInt(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 实现文本复制功能
     * add by wangqianzhou
     *
     * @param content
     */
    public static void copy(String content, Context context) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
    }
    /**
     * 根据id获取string
     */
    public static String getResourceString(Context context,int id){
        return context.getResources().getString(id);
    }
}
