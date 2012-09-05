package com.lsq.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsq.common.exception.ServiceException;
import com.lsq.dao.MenuDao;
import com.lsq.dao.RoleDao;
import com.lsq.dao.RoleMenuDao;
import com.lsq.model.Menu;
import com.lsq.model.Role;
import com.lsq.model.RoleMenu;
import com.lsq.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	
	@Override
	public void doEditSave(Role role, String[] menuIds)
			throws ServiceException {
		// TODO Auto-generated method stub
		roleDao.editSave(role);
		if(menuIds!=null){
			for(String menuId:menuIds){
				Menu menu = (Menu)menuDao.queryOne(Menu.class, menuId);
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setMenu(menu);
				roleMenu.setRole(role);
				roleMenuDao.editSave(roleMenu);
			}
		}
	}

	@Override
	public void doEditUpdate(Role role, String[] menuIds)
			throws ServiceException {
		// TODO Auto-generated method stub
		Set oldMenuSet = role.getRoleMenus();
		roleMenuDao.deleteAll(oldMenuSet);
		if(menuIds!=null){
			for(String menuId:menuIds){
				Menu menu = (Menu)menuDao.queryOne(Menu.class, menuId);
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setMenu(menu);
				roleMenu.setRole(role);
				roleMenuDao.editSave(roleMenu);
			}
		}
	}

	/**
	 * 删除多个角色
	 */
	public void deleteRoles(List<Role> roles) throws ServiceException {
		try{
		    for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
				Role role = (Role) iterator.next();
				roleDao.delete(role);
			}
		}catch (Exception e) {
			throw new ServiceException(getClass(), e.getMessage());
		}
	}
}
