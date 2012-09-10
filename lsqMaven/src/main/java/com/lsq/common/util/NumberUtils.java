package com.lsq.common.util;


import java.math.BigDecimal;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * 提供高精度的运算支持.
 * 所以函数以double为参数类型，兼容int与float.
 * 
 * @author calvin
 */
public class NumberUtils {

	private NumberUtils() {

	}

	/**
	 * 精确的加法运算.
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * 
	 * 精确的减法运算.
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 */
	public static double subtract(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	/**
	 * 提供精确的乘法运算.
	 */
	public static double multiply(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).doubleValue();
	}
	
	/**
	 * 提供精确的乘法运算，并对运算结果截位.
	 * 
	 * @param scale 运算结果小数后精确的位数
	 */
	public static double multiply(double v1, double v2,int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	/**
	 * 提供（相对）精确的除法运算.
	 * 
	 * @see #divide(double, double, int)
	 */
	public static double divide(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算.
	 * 由scale参数指定精度，以后的数字四舍五入.
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 表示表示需要精确到小数点以后几位
	 */
	public static double divide(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 提供精确的小数位四舍五入处理.
	 * 
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	  public static void main(String[] args) {
		  NumberFormat nf = NumberFormat.getInstance();
	        double dblNum = Math.PI;
	        System.out.println(dblNum);
	        nf.setMaximumIntegerDigits(5);
	        nf.setMinimumFractionDigits(4);
	        System.out.println("PI: " + getNumber(212));
	  }
	  private static String getNumber(long n) {
	         String result = null;
	         NumberFormat format = NumberFormat.getNumberInstance();
	         format.setMinimumIntegerDigits(6);
	         String nf = format.format(n);
	         result = nf.substring(0,3);
	         return result;
	     }

	public static String formatByLength(String maxId_end, int len) {
		if(StringUtils.isBlank(maxId_end)||"0".equals(maxId_end)||"null".equals(maxId_end))
			maxId_end="1";
		for(int i=maxId_end.length();i<len;i++){
			maxId_end = "0"+maxId_end;
		}
		return maxId_end;
	}

}
