package com.lsq.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsq.common.exception.ServiceException;
import com.lsq.dao.OperDao;
import com.lsq.model.Oper;
import com.lsq.service.OperService;

@Service("operService")
public class OperServiceImpl extends BaseServiceImpl implements OperService {

	@Autowired
	private OperDao operDao;
	@SuppressWarnings("unchecked")
	public boolean operExist(String loginName) throws ServiceException {
		List operList = operDao.query("from Oper where loginname = ?",new Object[]{loginName});
		if(operList!=null&&operList.size()>0){
			return true;
		}else{
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public void lockOpers(List<Oper> opers,Integer status) throws ServiceException {
		try{
		    for (Iterator iterator = opers.iterator(); iterator.hasNext();) {
		    	Oper oper = (Oper) iterator.next();
		    	if(oper.getStatus().equals(2)){
		    		throw new ServiceException(getClass(),"不可操作已注销用户！");
		    	}
		    	oper.setStatus(status);
		    	operDao.editUpdate(oper);
			}
		}catch (Exception e) {
			throw new ServiceException(getClass(), e.getMessage());
		}
		
	}
	
	public void editOper(Oper oper) throws ServiceException {
		try{
			Oper operPre = (Oper)operDao.queryOne(Oper.class, oper.getId());
			if(operPre!=null){
				if(StringUtils.isNotBlank(oper.getPassword())){
					operPre.setPassword(oper.getPassword());
				}
				operPre.setName(oper.getName());
				operPre.setAddress(oper.getAddress());
				operPre.setRole(oper.getRole());
				operPre.setIdno(oper.getIdno());
				operPre.setEmail(oper.getEmail());
				operPre.setPostcode(oper.getPostcode());
				operPre.setRemark(oper.getRemark());
				operPre.setTel(oper.getTel());
				operPre.setLastOpDate(oper.getLastOpDate());
			}
		}catch (Exception e) {
			throw new ServiceException(getClass(), e.getMessage());
		}
	}

}
