package org.spring.springboot.util;


import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 操作时间工具类
 * 
 * @author liyao
 * 
 *         2014年11月14日 下午3:42:23
 */
public class DateUtil {

	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public final static SimpleDateFormat datePattern = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 和当前时间比较大小
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param date
	 *            -- 需要比较时间
	 * @return -1,0,1
	 * @throws ParseException
	 */
	public static int compareToNow(String pattern, String date)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(format.parse(date));
		ca1.setTime(format.parse(getNowDate(pattern)));
		return ca.compareTo(ca1);
	}

	/**
	 * 两个时间相比较
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param date1
	 * @param date2
	 * @return -1,0,1
	 * @throws ParseException
	 */
	public static int dateCompare(String pattern, String date1, String date2)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(format.parse(date1));
		ca1.setTime(format.parse(date2));
		return ca.compareTo(ca1);
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param minDte
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(String pattern, String minDte,
			String maxDate, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String strDate = "";
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		if ("now".equalsIgnoreCase(date)) {
			strDate = getNowDate(pattern);
		} else {
			strDate = date;
		}
		ca.setTime(format.parse(minDte));
		ca1.setTime(format.parse(strDate));
		int min = ca.compareTo(ca1);
		ca.setTime(format.parse(strDate));
		ca1.setTime(format.parse(maxDate));
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @param minDate
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(String pattern, Date minDate,
			Date maxDate, String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String strDate = "";
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		if ("now".equalsIgnoreCase(date)) {
			strDate = getNowDate(pattern);
		} else {
			strDate = date;
		}
		ca.setTime(minDate);
		ca1.setTime(format.parse(strDate));
		int min = ca.compareTo(ca1);
		ca.setTime(format.parse(strDate));
		ca1.setTime(maxDate);
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断某个时间是否在某个范围之内（包含等于）
	 * 
	 * @param minDate
	 *            -- 范围的最小值
	 * @param maxDate
	 *            -- 范围的最大值
	 * @param date
	 *            -- 需要判断的值,now(不区分大小)表示当前时间
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareToScope(Date minDate, Date maxDate, Date date)
			throws ParseException {
		Calendar ca = Calendar.getInstance();
		Calendar ca1 = Calendar.getInstance();
		ca.setTime(minDate);
		ca1.setTime(date);
		int min = ca.compareTo(ca1);
		ca.setTime(date);
		ca1.setTime(maxDate);
		int max = ca.compareTo(ca1);
		if ((min == 0 || min == -1) && (max == 0 || max == -1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得当前时间
	 * 
	 * @param pattern
	 *            -- 时间格式
	 * @return
	 */
	public static String getNowDate(String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}

	/**
	 * 把时间转化为自定义格式
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String dateToString(String pattern, Date date) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将时间转为int
	 * 
	 * @param date
	 * @return
	 */
	public static int convertDateToInt(Date date) {
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 把Int转为Date
	 * 
	 * @param time
	 * @return
	 */
	public static Date convertIntToDate(Integer time) {
		return new Date((long) time * 1000);
	}

	/**
	 * 自定义格式把String转为Date类型
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String pattern, String date)
			throws ParseException {

		if (StringUtils.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(date);
	}

	public static String convertDateToString(Date date, String pattern)
			throws ParseException {

		if (StringUtils.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 获取相对于当前时间的任意时间
	 * 
	 * @param date
	 * @param interval
	 *            小时
	 * @throws ParseException
	 */
	public static Date getAnyTime(Date date, int interval)
			throws ParseException {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.HOUR_OF_DAY, interval);
		return cl.getTime();

	}

	/**
	 * 对两个时间进行拼接
	 * 
	 * @param date1
	 *            -- 时间1
	 * @param pattern1
	 *            -- 时间1的格式
	 * @param date2
	 *            -- 时间2
	 * @param pattern2
	 *            --时间2的格式
	 * @return date1+date2
	 */
	public static String DateJoin(Date date1, String pattern1, Date date2,
			String pattern2) {
		SimpleDateFormat format1 = new SimpleDateFormat(pattern1);
		SimpleDateFormat format2 = new SimpleDateFormat(pattern2);
		String str = format1.format(date1) + " " + format2.format(date2);
		return str;
	}

	/**
	 * 返回date1到date2之间所有为星期week-1的时间
	 * 
	 * @param date1
	 * @param date2
	 * @param week
	 *            -- 周几（Calendar.WEDNESDAY，TUESDAY...）
	 * @return
	 * @throws ParseException
	 */
	public static List<Date> getDateOfWeek(Date date1, Date date2, int week)
			throws ParseException {
		int day = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
		Calendar cal = Calendar.getInstance();
		List<Date> dates = new ArrayList<Date>();
		for (int i = 0; i < day; i++) {
			Date date = getAnyTime(date1, 24 * i);
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) == week) {
				dates.add(date);
			}
		}
		return dates;
	}

	/**
	 * 获取 firstDate 到 lastDate 之间每个月的 start号和end号
	 * (start,end的范围为1-31，如果某月不足31那么最大为当月的最后一天)
	 * 
	 * @param firstDate
	 * @param lastDate
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static Map<Date, Date> getDateOfMonth(Date firstDate, Date lastDate,
			int start, int end) throws ParseException {
		Map<Date, Date> map = new LinkedHashMap<Date, Date>();
		Calendar cal = Calendar.getInstance();
		Date startDate = null;
		Date endDate = null;
		int min = start >= end ? end : start;
		int max = start >= end ? start : end;
		cal.setTime(firstDate);
		if (min < cal.getActualMinimum(Calendar.DAY_OF_MONTH)) {
			min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		}
		if (max > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		cal.set(Calendar.DAY_OF_MONTH, min);
		startDate = cal.getTime();
		cal.set(Calendar.DAY_OF_MONTH, max);
		endDate = cal.getTime();
		map.put(startDate, endDate);
		while (true) {
			min = start >= end ? end : start;
			max = start >= end ? start : end;
			cal.set(Calendar.DAY_OF_MONTH,
					cal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1);
			Date temp = cal.getTime();
			cal.setTime(temp);
			if (min < cal.getActualMinimum(Calendar.DAY_OF_MONTH)) {
				min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
			}
			if (max > cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			}
			cal.set(Calendar.DAY_OF_MONTH, min);
			startDate = cal.getTime();
			cal.set(Calendar.DAY_OF_MONTH, max);
			endDate = cal.getTime();
			if (compareToScope(firstDate, lastDate, startDate)) {
				map.put(startDate, endDate);
			} else {
				break;
			}
		}
		return map;
	}

	/**
	 * 取得时间，精确到分，秒为0
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getTimeInMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.SECOND, 0);
		return convertDateToInt(c.getTime());
	}

	/**
	 * 把String时间类型转为Integer
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Integer convertStrDateToInt(String pattern, String date)
			throws ParseException {
		if (StringUtils.isEmpty(pattern)) {
			pattern = DEFAULT_PATTERN;
		}
		Date d = convertStringToDate(pattern, date);
		return convertDateToInt(d);
	}

	/**
	 * 把Integer时间类型转为String
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String convertIntDateToStr(String pattern, Integer date)
			throws ParseException {
		if (pattern == null || "".equals(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		Date d = convertIntToDate(date);
		return dateToString(pattern, d);
	}

	/**
	 * 取得当前时间戳
	 * 
	 * @return
	 */
	public static Integer nowTimestamp() {
		return convertDateToInt(new Date());
	}

	/**
	 * 取得当前日期字符串
	 * 
	 * @return
	 */
	public static String nowDateStr() {
		return datePattern.format(new Date());
	}



	///copy from qcs工程
	public final static SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd");
	public final static SimpleDateFormat  dd = new SimpleDateFormat("dd");

	public static String date_start = " 00:00:00";
	public static String date_end = " 23:59:59";
	/**
	 * 获取当天string
	 */
	public static String getCrrDay(Integer day) {
		Calendar cal = Calendar.getInstance();
		if(day != null){
			cal.add(Calendar.DATE, day);
		}
		String dateStart = df.format(cal.getTime());
		return dateStart;
	}

	public static String getCrrDay(Calendar cal, Integer day) {
		Calendar clone = (Calendar) cal.clone();
		if(day != null){
			clone.add(Calendar.DATE, day);
		}
		String dateStart = df.format(clone.getTime());
		return dateStart;
	}

	public static String getCrrDayStart(Integer day) {
		Calendar cal = Calendar.getInstance();
		if(day != null){
			cal.add(Calendar.DATE, day);
		}
		String dateStart = df.format(cal.getTime())+ date_start;
		return dateStart;
	}

	public static String getCrrDayEnd(Integer day) {
		Calendar cal = Calendar.getInstance();
		if(day != null){
			cal.add(Calendar.DATE, day);
		}
		String dateStart = df.format(cal.getTime()) + date_end;
		return dateStart;
	}

	/**
	 * 获取当年的第一天
	 */
	public static String getCrrYearFirstDay() {
		Calendar cal = Calendar.getInstance();
		// 获取今年第一天时间
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		String dateStart = df.format(calendar.getTime());
		return dateStart;
	}

	/**
	 * 当月第一天
	 *
	 * @return
	 */
	public static String getCrrMonthFirstDay() {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String oneDate = df.format(cal_1.getTime());
		return oneDate;
	}

	/**
	 * 当月最后一天
	 *
	 * @return
	 */
	public static String getCrrMonthLastDay() {
		Calendar cal_1 = Calendar.getInstance();
		cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastDate = df.format(cal_1.getTime());
		return lastDate;
	}
	/**
	 * 当月最后一天
	 *
	 * @return
	 */
	public static String getCrrMonthLastDay(Calendar cal) {
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastDate = dd.format(cal.getTime());
		return lastDate;
	}
	/**
	 * 上年同月第一天
	 *
	 * @return
	 */
	public static String getLastYearCrrMonthOneDay() {
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.add(Calendar.YEAR, -1);
		// String yearDateStart = df.format(cal.getTime());
		// System.out.println(yearDateStart);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String format = df.format(cal.getTime());
		return format;

	}

	/**
	 * 上年同月最后一天
	 *
	 * @return
	 */
	public static String getLastYearCrrMonthLastDay() {
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.add(Calendar.YEAR, -1);

		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastDate = df.format(cal.getTime());
		return lastDate;

	}

	/**
	 * 去年最后一天（到当天）
	 *
	 * @return
	 */
	public static String getLastYearlastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		String yearDateEnd = df.format(calendar.getTime());
		return yearDateEnd;
	}

	/**
	 * 获取当月天数
	 * @return
	 */
	public static int getCrrMonthSize(){
		Calendar cal = Calendar.getInstance();
		int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
		return dateOfMonth;
	}

	/**
	 * yearBefore年第一天
	 * @param yearBefore
	 * @return
	 */
	public static String getYearBrforeFirstDay(int yearBefore) {
		Calendar cal = Calendar.getInstance();
		// 获取今年第一天时间
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR)+yearBefore);
		String dateStart = df.format(calendar.getTime());
		return dateStart;
	}

	/**
	 * yearBefore年最后一天（到当天）
	 * @param yearBefore
	 * @return
	 */
	public static String getYearBrforeLastDay(int yearBefore) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, yearBefore);
		String yearDateEnd = df.format(calendar.getTime());
		return yearDateEnd;
	}

	public static String getYearBrforeLastDay(Calendar calendar, int yearBefore) {
		Calendar clone = (Calendar) calendar.clone();
		clone.add(Calendar.YEAR, yearBefore);
		String yearDateEnd = df.format(clone.getTime());
		return yearDateEnd;
	}
	/**
	 * 获取当前年份
	 * @return
	 */
	public static String getNowYear() {
		Calendar calendar = Calendar.getInstance();
		String nowyear = String.valueOf(calendar.get(Calendar.YEAR));
		return nowyear;
	}
	/**
	 * 去年第一天
	 * @return
	 */
	public static String getLastYearFirstDay(){
		Calendar cal = Calendar.getInstance();
		// 获取今年第一天时间
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR)-1);
		String dateStart = df.format(calendar.getTime());
		return dateStart;
	}

	/**
	 * 取得指定日期所在周的第一天
	 * @return
	 */
	public static String getFirstDayOfWeek(Calendar cal) {
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()); // Monday
		String dateStart = df.format(cal.getTime());
		return dateStart;
	}

	/**
	 * 取得指定日期所在周的最后一天
	 * @return
	 */
	public static String getLastDayOfWeek(Calendar cal) {
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+6); // Sunday
		cal.add(Calendar.DATE, 1);//sql包含enddate
		String dateStart = df.format(cal.getTime());
		return dateStart;
	}

	public static String getDate(String unixDate) {

		SimpleDateFormat fm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long unixLong = 0;
		String date = "";
		try {
			unixLong = Long.parseLong(unixDate) * 1000;
			date = fm1.format(unixLong);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return date;
	}
	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		System.out.println(getLastDayOfWeek(calendar));
		System.out.println(convertStringToDate("yyyy-MM-dd","2017-07-07"));

	}
}
