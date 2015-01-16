package com.my.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author zhimin
 *
 */
public class CalendarUtil {

	public static final String SHORT_FORMAT = "yyyy-MM-dd";
	public static final String LONG_FORMAT = "yyyy-MM-dd hh:mm:ss";

	public static String getShortDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_FORMAT);
		if (null == date || "".equals(date)) {
			date = new Date();
		}
		return sdf.format(date);
	}

	public static String getLongDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(LONG_FORMAT);
		if (null == date || "".equals(date)) {
			date = new Date();
		}
		return sdf.format(date);
	}

	/**
	 * 返回 周、月、年 开始时间
	 * 
	 * @param sectionId
	 * @return
	 */
	public static List<Date> getDateSection() {
		Calendar calendar = Calendar.getInstance();
		List<Date> list = new ArrayList<Date>();

		Date currDate = new Date();
		list.add(calendar.getTime());
		// 本周开始时间
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONTH);//
		// calendar.add(Calendar.WEEK_OF_YEAR, 1);
		list.add(calendar.getTime());

		// 本月开始时间
		calendar.setTime(currDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);//
		list.add(calendar.getTime());

		// 最近三月开始时间
		calendar.setTime(currDate);
		calendar.set(Calendar.DATE, 1);//
		calendar.add(Calendar.MONTH, -2);//
		list.add(calendar.getTime());
		// 最近6个月开始时间
		calendar.setTime(currDate);
		calendar.set(Calendar.DATE, 1);//
		calendar.add(Calendar.MONTH, -5);//
		list.add(calendar.getTime());
		// 今年开始时间
		calendar.setTime(currDate);
		calendar.set(Calendar.DATE, 1);//
		calendar.set(Calendar.MONTH, 0);//
		list.add(calendar.getTime());
		return list;
	}

	/**
	 * 日期时间比较
	 * 
	 * @param dateFormat
	 *            时间格式
	 * @param date1
	 *            时间字符串1
	 * @param date2
	 *            时间字符串2
	 * @return 返回 -1：小于，0：等于，1：大于
	 * @throws ParseException
	 */
	public static int compareTo(String dateFormat, String date1, String date2)
			throws ParseException {
		if (null == dateFormat || "".equals(dateFormat)) {
			dateFormat = SHORT_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		return d1.compareTo(d2);
	}
}
