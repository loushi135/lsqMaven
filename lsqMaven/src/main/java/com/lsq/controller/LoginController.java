package com.lsq.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.lsq.common.exception.ActionException;
import com.lsq.common.util.CreatMD5;
import com.lsq.common.util.GetMsgByExceptionUtil;
import com.lsq.model.Oper;
import com.lsq.model.Operlog;
import com.lsq.service.OperLogService;
import com.lsq.service.OperService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private OperService operService;
	@Autowired
	private OperLogService operLogService;
		@RequestMapping("/toLogin")
	    public ModelAndView toLogin(Model model) {
	       return new ModelAndView("login");
	    }
	 	
	 	@RequestMapping("/toIndex")
	    public String toIndex(String loginName,String password,String srand,HttpServletRequest request)throws ActionException {
	        String srandInSession = request.getSession().getAttribute("srand").toString();
	        RequestContext requestContext = new RequestContext(request);
	       
			if(StringUtils.isBlank(loginName)){
				request.setAttribute("msg", requestContext.getMessage("loginname.blank"));
				return "forward:/login/toLogin.do";
			}
			if(StringUtils.isBlank(password)){
	        	request.setAttribute("msg", requestContext.getMessage("password.blank"));
	        	return "login";
			}
			if(StringUtils.isBlank(srand)){
				request.setAttribute("msg", requestContext.getMessage("srand.blank"));
				return "login";
			}
			if(!srand.trim().equals(srandInSession)){
				request.setAttribute("msg", requestContext.getMessage("srand.error"));
				return "login";
			}
			try{
				password = CreatMD5.getMD5Info(password.trim());
				loginName = loginName.trim();
				List<Oper> list = operService.query("from Oper where loginname = ? and password = ?", new Object[]{loginName,password});
				if(list==null||list.size()<=0){
					request.setAttribute("msg", requestContext.getMessage("user.error"));
					return "login";
				}
				if(list.get(0).getStatus()==0){
					request.setAttribute("msg", requestContext.getMessage("user.enable"));
					return "login";
				}
				request.getSession().setAttribute("oper", list.get(0));
				
				Operlog operLog = new Operlog();
				operLog.setContent("用户登录");
				operLog.setIp(request.getRemoteAddr());
				operLog.setOpertime(new Timestamp(new Date().getTime()));
				operLog.setOper(list.get(0));
				operLogService.editSave(operLog);
			} catch (Exception e) {
				throw new ActionException(getClass(),GetMsgByExceptionUtil.getTrace(e));
			}
			return "index";
	    }
	 	

}
