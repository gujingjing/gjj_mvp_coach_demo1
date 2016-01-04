package mvp.gjj.androidbaselib.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期处理类
 * @author Wjia
 *
 */
public class DateUtils {
	
	public static final String DASH_YMD = "yyyy-MM-dd";
	public static final String DASH_YM = "yyyy-MM";
	public static final String DASH_MD = "MM-dd";
	public static final String DASH_DD = "dd";
	
	public static final String DASH_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
	public static final String DASH_HMS = "HH:mm:ss";
	public static final String DASH_HM = "HH:mm";

	public static final String ZH_YMD = "yyyy年MM月dd日";
	public static final String ZH_YM = "yyyy年MM月";
	public static final String ZH_Md = "MM月dd日";
	public static final String ZH_dd = "MM月dd日";

	public static final String ZH_YMD_HMS = "yyyy年MM月dd日 HH:mm:ss";
	
	public static final long MILLS_MIN = 60 * 1000; //一分钟多少毫秒
	public static final long MILLS_HOUR = MILLS_MIN * 60;//一小时多少毫秒
	public static final long MILLS_DAY = MILLS_HOUR * 24;//一天多少毫秒
	public static final long MILLS_WEEK = MILLS_DAY * 60;//一周多少毫秒

	public static final String DATEPATTERN_JODA="yyyy-MM-dd'T'HH:mm:ss.SSS'+08:00'";
	public static String toJodaString(Date date,String formt){
		return new SimpleDateFormat(formt).format(date);
	}
	/**
	 * 格式化日期返回时间戳
	 */
	public static long getLongTime(String formatStr, String dateStr){
		long lo=0;
		SimpleDateFormat sdf= new SimpleDateFormat(formatStr);
		try {
			Date dt2 = sdf.parse(dateStr);
			lo=dt2.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lo;
	}
	/**
	 * 格式化日期  
	 * 根据相应的字符串转化成时间
	 */
	public static Date getDateFromString(String formatStr, String dateStr) {
		try {
			return new SimpleDateFormat(formatStr).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
	/**
	 * 格式化日期  
	 * 根据相应的字符串转化成时间
	 */
	public static String getStringFromDate(String formatStr, Date date) {
		if (date != null)
		{
			return new SimpleDateFormat(formatStr).format(date);
		}else
		{
			return  "";
		}
	}
	/**
	 * 格式化日期
	 * 根据相应的字符串转化成时间
	 */
	public static String getStringFromDate(String formatStr, long date) {
		if (date != 0)
		{
			return new SimpleDateFormat(formatStr).format(date);
		}else
		{
			return  "";
		}
	}
	
	/**
	 * 获取系统当前时间long型
	 * 
	 * @return
	 */
	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 时间选择空间格式化日期(当前时间)
	 */
	/**
	 * 格式化日期：年月日
	 *
	 * @return
	 */
	public static String formatDateForPicker() {
		return new SimpleDateFormat(ZH_YMD).format(new Date());
	}
	
	/**
	 * 
	 * 计算时间差
	 * 
	 * 传入时间，到当天
	 * 要是传入的时间格式包含：年月日时间秒
	 *格式化参数： DASH_YMD_HMS 或者是 ZH_YMD_HMS
	 * 
	 * @return
	 */
	public static int getDays(String formatStr,String dateStr) {
		long timeMillis = 0l;
		try {
			timeMillis = getCurrentTimeMillis() - (new SimpleDateFormat(formatStr).parse(dateStr)).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int) (timeMillis / MILLS_DAY);
	}

	/**
	 * 获取当前周的周一和周日的日期数组
	 */
	public static Long[] getWeeksAllDayArray(Long date) {

		Calendar calendar = Calendar.getInstance();

		Calendar c = Calendar.getInstance();
		c.setTime(new Date(date));
		int weekDay = c.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DATE, Calendar.MONDAY - weekDay);
		Date start = c.getTime();
		//周二
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date(date));
		int weekDay2 = c2.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c2.get(Calendar.DAY_OF_WEEK);
		c2.add(Calendar.DATE, Calendar.TUESDAY - weekDay2);
		Date tue = c2.getTime();
		//周三
		Calendar c3 = Calendar.getInstance();
		c3.setTime(new Date(date));
		int weekDay3 = c3.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c3.get(Calendar.DAY_OF_WEEK);
		c3.add(Calendar.DATE, Calendar.WEDNESDAY - weekDay3);
		Date we = c3.getTime();
		//周四
		Calendar c4 = Calendar.getInstance();
		c4.setTime(new Date(date));
		int weekDay4 = c4.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c4.get(Calendar.DAY_OF_WEEK);
		c4.add(Calendar.DATE, Calendar.THURSDAY - weekDay4);
		Date thus = c4.getTime();
		//周五
		Calendar c5 = Calendar.getInstance();
		c5.setTime(new Date(date));
		int weekDay5 = c5.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c5.get(Calendar.DAY_OF_WEEK);
		c5.add(Calendar.DATE, Calendar.FRIDAY - weekDay5);
		Date fri = c5.getTime();
		//周六
		Calendar c6 = Calendar.getInstance();
		c6.setTime(new Date(date));
		int weekDay6 = c6.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : c6.get(Calendar.DAY_OF_WEEK);
		c6.add(Calendar.DATE, Calendar.SATURDAY - weekDay6);
		Date sat = c6.getTime();
		//周日
		c.add(Calendar.DATE, 6);
		Date end = c.getTime();
		Long [] times = {start.getTime(),
				tue.getTime(),
				we.getTime(),thus.getTime(),fri.getTime(),sat.getTime(),
				end.getTime()};
		return times;
	}

	/**
	 * 获取当前是第几年
	 * @return
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 获取当前的是第几个月
	 * @return
	 */
	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	/**
	 * 格式当前日期化日期：年月日
	 *
	 * @return
	 */
	public static String formatDate(String string) {
		return new SimpleDateFormat(string).format(new Date());
	}
	/**
	 * 格式指定日期日期化日期：年月日
	 *
	 * @return
	 */
	public static String formatDate(String string,long time) {
		Date date=new Date(time);
		return new SimpleDateFormat(string).format(date);
	}
	public static String formatDate(String string,Date date) {
		return new SimpleDateFormat(string).format(date);
	}
	/**
	 * 计算两个时间的时间差
	 * 
	 * 格式化参数： DASH_YMD_HMS 或者是 ZH_YMD_HMS
	 */
	public static long getDays(String formatStr,String  dateStr1,String dateStr2) {
		long timeMillis = 0l;
		try {
			timeMillis = (new SimpleDateFormat(formatStr).parse(dateStr1)).getTime() - (new SimpleDateFormat(formatStr).parse(dateStr2)).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeMillis;
	}
	
	/**
	 * 每个月第一天的时间戳
	 * 
	 * @return
	 */
	public static long getMonthFirstDay(int month) {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTimeInMillis();
	}

	//  实现给定某日期，判断是星期几
	public static String getWeekday(long time){//必须yyyy-MM-dd
		String date=formatDate(DASH_YMD, time);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdw.format(d);
	}
	/**
	 * 根据年月日获取时间戳(凌晨00:00:00)
	 * 
	 * @return
	 */
	public static long getInMillsByYMD(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);// 设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTimeInMillis();
	}
	/**
	 * 获取当前日期的前后几天
	 */
	public static String getStatetime(int day){

		SimpleDateFormat sdf = new SimpleDateFormat(DASH_YM);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		Date monday = c.getTime();
		String preMonday = sdf.format(monday);
		return preMonday;
	}
	public static long getStatetime_long(int day){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		Date monday = c.getTime();
		return monday.getTime();
	}

	/**
	 * 指定时间的以后的第几天日期
	 * @param longTime
	 * @param day
	 * @return
	 */
	public static long getStatetime_long(long longTime,int day){
		Calendar c = Calendar.getInstance();
			c.setTime(new Date(longTime));
		c.add(Calendar.DATE, day);
		Date monday = c.getTime();
		return monday.getTime();
	}
	/**
	 * 计算两个时间之间相差的天数
	 */
	public static int getDayNumber(long startTime,long endTime){
		SimpleDateFormat df = new SimpleDateFormat(DASH_YMD);
		long to = 0;
		long from=0;
		try {
			from = df.parse(formatDate(DASH_YMD,new Date(startTime))).getTime();
			to = df.parse(formatDate(DASH_YMD,new Date(endTime))).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println((to - from) / (1000 * 60 * 60 * 24));
		return (int)((to - from)/(1000 * 60 * 60 * 24));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}
}
