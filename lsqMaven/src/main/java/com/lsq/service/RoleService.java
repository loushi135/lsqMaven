package com.lsq.service;

import java.util.List;

import com.lsq.common.exception.ServiceException;
import com.lsq.model.Role;


public interface RoleService extends BaseService {

	public void doEditSave(Role role,String[] menuIds)throws ServiceException;
	public void doEditUpdate(Role role,String[] menuIds)throws ServiceException;
	
	public void deleteRoles(List<Role> roles) throws ServiceException;
	
}
