package com.framgia.hepler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class ConvertDateSql {
	private static final Logger logger = Logger.getLogger(ConvertDateSql.class);
	public static String date_time_format = "yyyy-MM-dd HH:mm:ss";
	public static String date_format = "yyyy-MM-dd";
	private static final String TYPE_HH_MM ="HH:mm";

	public static Date getDateNow() {
		try {
			DateFormat df = new SimpleDateFormat(date_time_format);
			Date date = new Date();
			Date convertedCurrentDate;
			convertedCurrentDate = df.parse(df.format(date));
			return convertedCurrentDate;
		} catch (ParseException e) {
			logger.error("Error getDateNow: ", e);
		}
		return null;
	}

	public static java.sql.Date getDateNowSQL() {
		try {
			return new java.sql.Date(getDateNow().getTime());
		} catch (Exception e) {
			logger.error("Error getDateNowSQL: ", e);
			return null;
		}
	}

	public static String convertDatetoString(Date date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(date_format);
			return dateFormat.format(date);

		} catch (Exception e) {
			logger.error("Error convertDatetoString: ", e);

			return null;
		}
	}

	public static String convertDateTimetoString(Date date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(date_time_format);
			return dateFormat.format(date);

		} catch (Exception e) {
			logger.error("Error convertDateTimetoString: ", e);

			return null;
		}
	}

	public static Date convertStringtoDate(String strDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(date_format);
			return sdf.parse(strDate);
		} catch (Exception e) {
			logger.error("Error convertStringtoDate: ", e);
			return null;
		}
	}

	public static java.sql.Date convertStringtoDateSQL(String strdate) {
		try {
			return new java.sql.Date(convertStringtoDate(strdate).getTime());
		} catch (Exception e) {
			logger.error("Error convertStringtoDateSQL: ", e);
			return null;
		}
	}

	public static Date convertStringtoDateTime(String strDate) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(date_time_format);
			Date convert = df.parse(strDate);
			return convert;
		} catch (Exception e) {
			logger.error("Error convertStringtoDateTime: ", e);
			return null;
		}
	}

	public static java.sql.Date convertStringtoDateTimeSQL(String strDate) {
		try {
			return new java.sql.Date(convertStringtoDateTime(strDate).getTime());
		} catch (Exception e) {
			logger.error("Error convertStringtoDateTimeSQL: ", e);
			return null;
		}
	}
	public static SimpleDateFormat getSimpleDateFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(date_format);
		return dateFormat;
	}
	public static String dateFormatHH_mm() {
		return new SimpleDateFormat(TYPE_HH_MM).format(new Date());
		
	}
	public static Date convertDateToSave(java.util.Date date){
		java.util.Date dateFormat = new Date(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat(date_format);
		String format = formatter.format(dateFormat);
		return convertStringtoDate(format);
	}
}
