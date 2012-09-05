package com.lsq.common.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	public DateUtils() {
	}

	/*** ������ת��Ϊ�ַ�
	 * �ַ���?("YYYY-MM-DD")��Сʱ���֡��뱻���ԡ�
	 */
	public static String DateToString(Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");
		String strDateTime = formater.format(date);
		return strDateTime;
	}

	
	
	public static String DateToStringChart(Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
			"yyyyMMddHHmmssSS");
		String strDateTime = formater.format(date);
		return strDateTime;
	}
	/*** ������ת��Ϊ�ַ�
	 * @param Date ����
	 * @param pattern ���ڸ�ʽ
	 * @return String ����
	 */
	public static String DateToString(Date date, String pattern)  {
		String strDateTime = null;
		try {
			java.text.SimpleDateFormat formater = new java.text.
				SimpleDateFormat(
				pattern);
			strDateTime = formater.format(date);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return strDateTime;
	}

	/**
	 * �������������ת��ΪDate����
	 * @param year ��
	 * @param month ��
	 * @param day ��
	 * @return Date����
	 */
	public static Date YmdToDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	/**
	 * ������ת��Ϊ�ַ�
	 * �ַ���?("YYYY-MM-DD")��Сʱ���֡��뱻���ԡ�
	 */
	public static String communityDateToString(Date date) {
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(
			"MM/dd HH:mm:ss");
		String strDateTime = formater.format(date);
		return strDateTime;
	}

	/**
	 * ���ַ�ת��Ϊ���ڡ�
	 * �ַ���?("YYYY-MM-DD")��
	 * ���磺"2002-07-01"����"2002-7-1"����"2002-7-01"����"2002-07-1"�ǵȼ۵ġ�
	 */
	public static Date StringToDate(String str) {
		Date dateTime = null;
		try {
			if (! (str == null || str.equals(""))) {
				java.text.SimpleDateFormat formater = new java.text.
					SimpleDateFormat("yyyy-MM-dd HH:mm");
				dateTime = formater.parse(str);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			return dateTime;
		}
	}
	public static Date StringToDate2(String str) {
		Date dateTime = null;
		try {
			if (! (str == null || str.equals(""))) {
				java.text.SimpleDateFormat formater = new java.text.
					SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				dateTime = formater.parse(str);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			return dateTime;
		}
	}
	public static Date StringToDate4(String str) {
		Date dateTime = null;
		try {
			if (! (str == null || str.equals(""))) {
				java.text.SimpleDateFormat formater = new java.text.
					SimpleDateFormat("yyyy-MM-dd");
				dateTime = formater.parse(str);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			return dateTime;
		}
	}
	
	public static Date StringToDate3(String str) {
		Date dateTime = null;
		try {
			if (! (str == null || str.equals(""))) {
				java.text.SimpleDateFormat formater = new java.text.
					SimpleDateFormat("HH:mm:ss");
				dateTime = formater.parse(str);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			return dateTime;
		}
	}
	/**
	 * ���ַ�ת��Ϊ���ڡ�
	 * �ַ���?("YYYY-MM-DD")��
	 * ���磺"2002-07-01"����"2002-7-1"����"2002-7-01"����"2002-07-1"�ǵȼ۵ġ�
	 */
	public static Date StringToDate(String str,String patten) {
		Date dateTime = null;
		try {
			if (! (str == null || str.equals(""))) {
				java.text.SimpleDateFormat formater = new java.text.
					SimpleDateFormat(patten);
				dateTime = formater.parse(str);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally {
			return dateTime;
		}
	}


	/**
	 * ���޸�����2008-9-7 22��23��03 ���? 2008-09-07 22��23��03
	 * ����ʱ���ʱ�����Timestamp��ʾ
	 * @return Timestamp
	 */
	public static Timestamp StringToDateHMS(String str) throws Exception {
		Timestamp time = null;
		try {
			String[] strarr1 = str.split(" ");
			String  day = strarr1[0];
			String[] strarr2 = day.split("-");

			for(int i=1;i<strarr2.length;i++)
			{
				if(!(strarr2[i].length()==2))
				{
				    strarr2[i] = "0"+strarr2[i];
				}
			}
			StringBuffer buffer = new StringBuffer();
			buffer.append(strarr2[0]);
			buffer.append("-");
			buffer.append(strarr2[1]);
			buffer.append("-");
			buffer.append(strarr2[2]);
			buffer.append(" ");
			buffer.append(strarr1[1]);
			time = java.sql.Timestamp.valueOf(buffer.toString());

		}
		catch (Exception ex) {

			System.out.print(ex.toString());
		}

		return time;

	}

	/**
	 * ȡ��һ��date�����Ӧ�����ڵ�?0��0��0��ʱ�̵�Date����
	 * @param date һ������
	 * @return Date����
	 */
	public static Date getMinDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,
					 calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND,
					 calendar.getActualMinimum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 * ȡ��һ��date�����Ӧ�����ڵ�?23��59��59��ʱ�̵�Date����
	 * @param date һ������
	 * @return Date����
	 */
	public static Date getMaxDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,
					 calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND,
					 calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}
	

	

}