package com.lsq.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HtmlHelper {
	/** 
	 * 生成静�?�页面主方法
	 * @author zhaobin
	 * @param context ServletContext 
	 * @param data �?个Map的数据结果集 
	 * @param templatePath ftl模版名称
	 * @param htmlName 生成的静态页面的名称
	 */ 
	public static void createHTML(ServletContext context,Map<String,Object> data,String templateName,String htmlName){ 
		Configuration freemarkerCfg = new Configuration(); 
		//加载模版 
		freemarkerCfg.setServletContextForTemplateLoading(context, "/web/ftl/"); 
		freemarkerCfg.setEncoding(Locale.CHINA, "UTF-8"); 
		try { 
			//指定模版路径 
			Template template = freemarkerCfg.getTemplate(templateName,"UTF-8"); 
			template.setEncoding("UTF-8"); 
			//静�?�页面路�? 
			String htmlPath = context.getRealPath("/web/html")+"/"+htmlName; 
			File htmlFile = new File(htmlPath); 
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			//处理模版  
			template.process(data, out); 
			out.flush(); 
			out.close(); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}