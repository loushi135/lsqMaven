package com.lsq.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import com.lsq.common.exception.ActionException;
import com.lsq.common.util.CreatMD5;
import com.lsq.common.util.GetMsgByExceptionUtil;
import com.lsq.model.Oper;
import com.lsq.model.Operlog;
import com.lsq.model.Role;
import com.lsq.model.RoleMenu;
import com.lsq.service.OperLogService;
import com.lsq.service.OperService;
import com.lsq.service.RoleMenuService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private OperService operService;
	@Autowired
	private OperLogService operLogService;
	@Autowired
	private RoleMenuService roleMenuService;
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager = null;
	 	
	 	@RequestMapping("/toIndex")
	    public String toIndex(String loginName,String password,String srand,HttpServletRequest request)throws ActionException {
	 		if(request.getSession()==null){
	 			return "redirect:/login.jsp";
	 		}
	        String srandInSession = request.getSession().getAttribute("srand").toString();
	        RequestContext requestContext = new RequestContext(request);
	       
			if(StringUtils.isBlank(loginName)){
				request.setAttribute("msg", requestContext.getMessage("loginname.blank"));
				return "redirect:/login.jsp";
			}
			if(StringUtils.isBlank(password)){
	        	request.setAttribute("msg", requestContext.getMessage("password.blank"));
	        	return "redirect:/login.jsp";
			}
			if(StringUtils.isBlank(srand)){
				request.setAttribute("msg", requestContext.getMessage("srand.blank"));
				return "redirect:/login.jsp";
			}
			if(!srand.trim().equals(srandInSession)){
				request.setAttribute("msg", requestContext.getMessage("srand.error"));
				return "redirect:/login.jsp";
			}
			try{
				password = CreatMD5.getMD5Info(password.trim());
				loginName = loginName.trim();
				List<Oper> list = operService.query("from Oper where loginname = ? and password = ?", new Object[]{loginName,password});
				if(list==null||list.size()<=0){
					request.setAttribute("msg", requestContext.getMessage("user.error"));
					return "redirect:/login.jsp";
				}
				if(list.get(0).getStatus()==0){
					request.setAttribute("msg", requestContext.getMessage("user.enable"));
					return "redirect:/login.jsp";
				}
				request.getSession().setAttribute("oper", list.get(0));
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
						loginName, password);
				SecurityContext securityContext = SecurityContextHolder.getContext();
				securityContext.setAuthentication(authenticationManager.authenticate(authRequest));
				SecurityContextHolder.setContext(securityContext);
				Operlog operLog = new Operlog();
				operLog.setContent("用户登录");
				operLog.setIp(request.getRemoteAddr());
				operLog.setOpertime(new Timestamp(new Date().getTime()));
				operLog.setOper(list.get(0));
				operLogService.editSave(operLog);
				Oper oper = list.get(0);
				Role myRole = oper.getRole();
				List<RoleMenu> roleMenuList = roleMenuService.query(" from RoleMenu where menu.parentMenu.menuId='0' and role.roleId=? order by menuOrder", new Object[]{myRole.getRoleId()});
				List<RoleMenu> childRoleMenuList = roleMenuService.query(" from RoleMenu where menu.parentMenu.menuId!='0' and role.roleId=?", new Object[]{myRole.getRoleId()});
				for(RoleMenu parentRoleMenu:roleMenuList){
					parentRoleMenu.getMenu().getChildList().clear();
					for(RoleMenu roleMenu:childRoleMenuList){
						if(roleMenu.getMenu().getParentMenu().getMenuId().equals(parentRoleMenu.getMenu().getMenuId())){
							parentRoleMenu.getMenu().getChildList().add(roleMenu.getMenu());
						}
					}
				}
				request.setAttribute("roleMenuList", roleMenuList);
			} catch (Exception e) {
				throw new ActionException(getClass(),GetMsgByExceptionUtil.getTrace(e));
			}
			return "index";
	    }
	 	@RequestMapping("/logout")
	 	public String logout(HttpServletRequest request)throws ActionException{
	 		Oper oper = (Oper)request.getSession().getAttribute("oper");
			if (oper != null) {
				Operlog operLog = new Operlog();
				operLog.setContent("用户退出");
				operLog.setIp(request.getRemoteAddr());
				operLog.setOper(oper);
				operLog.setOpertime(new Timestamp(new Date().getTime()));
				try {
					operLogService.editSave(operLog);
				} catch (Exception e) {
					throw new ActionException(getClass(),GetMsgByExceptionUtil.getTrace(e));
				}finally{
					request.getSession().removeAttribute("oper");
				}
			}
	 		return "redirect:/login.jsp";
	 	}

}
