package mvp.gjj.androidbaselib.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * SharedPreferences封装类
 */
public class SharedPrefsUtil {
	//共享文件
	public static final String SHARE_NAME = "sharePrefer_gjj";
	static SharedPreferences sp = null;

	public static SharedPreferences getSp(Context context) {
		if (sp == null) {
			sp = context.getSharedPreferences(SHARE_NAME, 0);
		}
		return sp;
	}

	/**
	 * 查询缓存值
	 * 
	 * @param context
	 * @param key
	 * @param id
	 */
	public static void putInt(Context context, String key, int id) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.putInt(key, id);
		spEdit.commit();
	}

	/**
	 * 查询缓存值
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static int getInt(Context context, String key) {
		return getSp(context).getInt(key, -1);
	}

	/**
	 * 查询缓存值
	 * 
	 * @param context
	 * @param key
	 */
	public static void putString(Context context, String key, String str) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.putString(key, str);
		spEdit.commit();
	}

	/**
	 * 获取string
	 */
	public static String getString(Context context, String key) {
		return getSp(context).getString(key, null);
	}

	/**
	 * 获取Float
	 */
	public static float getFloat(Context context, String key) {
		return getSp(context).getFloat(key, -1F);
	}

	/**
	 * 设置
	 */
	public static void putLong(Context context, String key, long l) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.putLong(key, l);
		spEdit.commit();
	}

	/**
	 * 
	 */
	public static long getLong(Context context, String key) {
		return getSp(context).getLong(key, -1L);
	}

	public static long getLong(Context context, String key, long defaultValue) {
		return getSp(context).getLong(key, defaultValue);
	}

	/**
	 * 查询缓存值
	 * 
	 * @param context
	 * @param key
	 * @param b
	 */
	public static void putBoolean(Context context, String key, boolean b) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.putBoolean(key, b);
		spEdit.commit();
	}

	/**
	 * 查询缓存值
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Context context, String key) {
		return getSp(context).getBoolean(key, false);
	}

	/**
	 * 缓存Set集合值
	 * 
	 * @param context
	 * @param key
	 * @param ids
	 */
	public static void putSet(Context context, String key, Set<String> ids) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.putStringSet(key, ids);
		spEdit.commit();
	}

	public static void remove(Context context, String key) {
		SharedPreferences.Editor spEdit = getSp(context).edit();
		spEdit.remove(key);
		spEdit.commit();
	}

	/**
	 * SharedPreferenc 存储对象
	 * 
	 * @param context
	 * @param key
	 * @param obj
	 */
	public static void putObjectStream(Context context, String key, Object obj) {
		ByteArrayOutputStream baos;
		try {
			baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			// Save user preferences. use Editor object to make changes.
			SharedPreferences.Editor spEdit = getSp(context).edit();
			String strObj = new String(Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT));
			spEdit.putString(key, strObj);
			spEdit.commit();
		} catch (IOException e) {
			LogUtil.e("IOException",e.toString());
		}
	}

	/**
	 * 从SharedPreferences文件流中获取对象
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static Object getObjectStream(Context context, String key) {
		try {
			String paramBase64 = getSp(context).getString(key, null);
			byte[] base64Bytes = Base64.decode(paramBase64.getBytes(), Base64.DEFAULT);
			ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			LogUtil.e("Exception", e.toString());
		}
		return null;
	}
}
