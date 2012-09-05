package com.lsq.common.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class StringUtil {
	public static String getNewStr(String str){
		try {
			if(str!=null&&!"".equals(str))
				str=new String(str.getBytes("ISO-8859-1"), "GBK");//处理中文乱码

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return str;
	}
	
	public static String Html2Text(String srcStr) {
		Pattern ptn = Pattern.compile("<[^>]+>|[&nbsp;]",Pattern.CASE_INSENSITIVE);
		return ptn.matcher(srcStr).replaceAll("");
	}
	
	public static String highLigter(String srcStr,String destStr) {
		return srcStr.replaceAll(destStr,"<font color=\"red\">"+destStr+"</font>");
	}
	
	public static String textAreaConvert(String sp, String sp1, String sp2) {
		String sTemp = sp;
		String str = "";
		if (sp == null || sp.equals("")) {
			return str;
		}
		try {
			int iIndex = sTemp.indexOf(sp1);
			int iStar = 0;
			while (iIndex != -1) {
				String s1 = sTemp.substring(iStar, iIndex);
				if (iIndex < sTemp.length()) {
					sTemp = sTemp.substring(iIndex + 1, sTemp.length());
					s1 = s1 + sp2;
					str = str + s1;
					iIndex = sTemp.indexOf(sp1);
				}
			}
			str = str + sTemp;
		} catch (Exception e) {

		}
		return str;
	}
}
