package com.lsq.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class GetNewsByOtherWeb {
	public static void main(String[] args) throws Exception {
//		System.out.println(getNewsContentByURL("http://www.jkb.com.cn/document.jsp?docid=222165&cat=09C","gbk"));
//		System.out.println(getTitleURLAndPublishDate(50,null,10));
//		System.out.println(getNewsContentByURL("http://www.baidu.com","gbk"));
	}

	// ��ȡ��������
	public static String getNewsContentByURL(String url,String charset) throws Exception {
		String data = fetchData(url,charset);
		Pattern ptn = Pattern.compile("<div id=\"docContent\">.+</div>");
		Matcher m = ptn.matcher(data);
		String temp = null;
		while(m.find()) {
			temp = m.group();
		}
		if(temp.trim().length() > 0) {
			temp = temp.substring(0, temp.indexOf("</td>"));
			temp = temp.replaceAll("<div id=\"docContent\">", "").replaceAll("</div>", "");
		}
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	// ��ȡָ����Ŀ������
	public static String getTitleURLAndPublishDate(int flag,String date,int num) throws Exception {
		String url = null;
		Pattern ptn = null;
		String charSet = null;
		if(flag == 1) { //����
			url = "http://www.moh.gov.cn/publicfiles/business/htmlfiles/wsb/pxwzx/list.htm";
			ptn = Pattern.compile("<xml id=\"DocumentsDataSrc18\">.+</xml>");
			charSet = "utf-8";
		}
		if(flag == 2) { // ʡ������
			url = "http://www.jswst.gov.cn/gb/jsswst/wsyw/index.html";
		}
		if(flag == 3) { // ���ҩ���
			url = "http://www.sda.gov.cn/WS01/CL0004/";
			ptn = Pattern.compile("<A href='\\.+/.+/.+\\.html' target='_blank'>" +
	 				"<FONT style=\"\" color=\"\">.*</FONT>" + 
				"</A><SPAN class='.*'>\\(\\d{4}-\\d{2}-\\d{2}\\)</SPAN>");			
			charSet = "gbk";
		}
		if(flag == 4) { // ʡҩ���?
			url = "http://www.jsfda.gov.cn/col/col30/index.html";
		}
		 // ������(50��Ҫ�� 51��ҽ�??��? 52���Ƽ����� 53��ý������ 54����ȱ���? 55��Ȩ������)
		if(flag == 50 || flag == 51 || flag == 52 || flag == 53 || flag == 54 || flag == 55) {
			url = "http://www.jkb.com.cn/navigate.jsp?selectedCat=";
			if(flag == 50) url += "0D";
			if(flag == 51) url += "0I";
			if(flag == 52) url += "09C";
			if(flag == 53) url += "0K";
			if(flag == 54) url += "0J";
			if(flag == 55) url += "09E";			
			ptn = Pattern.compile("<tr>"+
                          "<td width=\"80%\" height=\"22\">" + 
                          	"<img src=\"Styles/bluesky2/images/sm_pic.gif\" width=\"4\" height=\"5\" hspace=\"5\"/>"+
                            ".*"+
                          "</td>" + 
                          "<td width=\"30%\" align=\"right\">" + 
	                      	"<script language=\"JavaScript\" type=\"text/javascript\">" + 
	                      		".*"+
	                      	"</script>"+
	                          "<span class=\"grayfontColor\">"+
	                          	".*"+
	                          "</span>"+
                          "</td>" + 
                       "</tr>");
			charSet = "gbk";
		}
		if(flag == 6) { // �й�ҽҩ��
			url = "http://www.cntcm.com.cn/";
		}
		String content = fetchData(url,charSet);
		Matcher m = ptn.matcher(content);
		String temp = null;
		String result = "";
		while(m.find()) {
			temp = m.group();
		}
		if(temp != null) {
			if(flag == 1) { //����
				int index = 0;
				Document document = DocumentHelper.parseText(temp);
				List list = document.selectNodes("/xml/RECS/INFO");
				temp = "";
				for(int x = 0; x < list.size(); x++) {
					Element element = (Element) list.get(x);
					Node InfoTitle = element.selectSingleNode("InfoTitle");
					Node InfoURL = element.selectSingleNode("InfoURL");
					Node PublishedTime = element.selectSingleNode("PublishedTime");
					temp += "<A href='http://www.moh.gov.cn/publicfiles/business/htmlfiles/"+InfoURL.getText()+"' target='_blank'>"+InfoTitle.getText()+"</A><SPAN >("+PublishedTime.getText()+")</SPAN>";
					if(num != -1) {
						++index;
						if(index == num) break; 
					}
				}
			}
			if(flag == 2) { // ʡ������
			}
			String temp1 = "";
			if(flag == 3) { // ���ҩ���
				temp.replaceAll("</TD><TD class='listnew15'></TD></TR><TR class=''><TD class='ListColumnClass15'>", "")
				.replaceAll("</TD><TD class='listnew15'></TD></TR><TR><TD class='distance15' colspan='3'></TD></TR><TR class=''><TD class='ListColumnClass15'>","")
				.replaceAll("class='listtddate15'","")
				.replaceAll("<FONT style=\"\" color=\"\">","")
				.replaceAll("</FONT>","")
				.replaceAll("\\.\\.", "http://www.sda.gov.cn/WS01");
				if(num != -1) {
					int index = 0;
					String[] arrs = temp.split("</SPAN>");
					for(int x = 0; x < arrs.length; x++) {
						++index;
						temp1 += arrs[x] + "</SPAN>";
						if(index == num) break; 
					}
					temp = temp1;
				}
			}
			if(flag == 4) { // ʡҩ���?
			}
			if(flag == 50 || flag == 51 || flag == 52 || flag == 53 || flag == 54 || flag == 55) { // ������
				temp = temp.replaceAll("<tr><td width=\"80%\" height=\"22\"><img src=\"Styles/bluesky2/images/sm_pic.gif\" width=\"4\" height=\"5\" hspace=\"5\"/>","")
				.replaceAll("</td><td width=\"30%\" align=\"right\">", "")
				.replaceAll("</td></tr>", "")
				.replaceAll("class=\"al\"", "")
				.replaceAll("<script language=\"JavaScript\" type=\"text/javascript\">","")
				.replaceAll("</script>", "").replaceAll("\\t+", "").replaceAll("before2\\('\\d{4}-\\d{2}-\\d{2}'\\)","")
				.replaceAll("href", " href")
				.replaceAll("document.jsp", "http://www.jkb.com.cn/document.jsp")
				.replaceAll("target=\"_blank\"", "")
				.replaceAll(" class=\"grayfontColor\"", "")
				.replaceAll("\\s{2,5}", " ")
				.replaceAll(" <span>", "<span>");
//			if(num != -1) {
//				int index = 0;
//				String[] arrs = temp.split("</span>");
//				for(int x = 0; x < arrs.length; x++) {
//					++index;
//					temp1 += arrs[x] + "</span>";
//					if(index == num) break; 
//				}
//				temp = temp1;
//			}
				temp = temp.replaceAll("<span>","").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("<a href=\"", "").replaceAll(">", ",").replaceAll("</a", "").replaceAll("</span", "#")
				.replaceAll("\"", "").replaceAll("#,", "#").replaceAll("<tr height=22,<td/,</tr,", "");
				temp = temp.substring(0, temp.length()-1);
				
				String[] items = null;
				String[] item = null;
				String date_ = null;
				int count = 0;
				String temp2 = "";
				String url_ = "";
				String title = "";
				
				// ���ڡ���Ŀ
				if(date != null && !"".equals(date.trim()) && num != -1) {
					items = temp.split("#");
					for(int x=0;x<items.length;x++) {
						item = items[x].split(",");
						url_ = item[0];
						title = item[1];
						date_ = item[2];
						if(date_.equals(date)) {
							count++;
							temp2 += url_ + ","  + title + "," + date_ +  "#";
							if(count == num) break; 
						}
					}
					if(temp2.trim().length() > 0) {
						result = temp2.substring(0, temp2.length()-1);
					}
				} else { // ��Ŀ
					items = temp.split("#");
					for(int x=0;x<items.length;x++) {
						item = items[x].split(",");
						url_ = item[0];
						title = item[1];
						date_ = item[2];					
						count++;
						temp2 += url_ + ","  + title + "," + date_ +  "#";
						if(count == num) break;
					}	
					if(temp2.trim().length() > 0) {
						result = temp2.substring(0, temp2.length()-1);
					}
				}
				
			}
			if(flag == 6) { // �й�ҽҩ��
			}		
		}
		return result;
	}
	
	public static String fetchData(String srcUrl,String charset) throws Exception {
		URL url = new URL(srcUrl);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		InputStream in = url.openStream();		
		StringBuffer s = new StringBuffer();
		if (charset == null || "".equals(charset)) {
			charset = "utf-8";
		}
		String rLine = null;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(in,charset));
		while ((rLine = bReader.readLine()) != null) {
			String tmp_rLine = rLine;
			int str_len = tmp_rLine.length();
			if (str_len > 0) {
				s.append(tmp_rLine);
			}
			tmp_rLine = null;
		}
		in.close();
		return s.toString();
	}
}
