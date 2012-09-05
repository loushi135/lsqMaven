package com.lsq.service;

import java.util.List;

import com.lsq.common.exception.ServiceException;
import com.lsq.model.Oper;



public interface OperService extends BaseService{
   public boolean operExist(String loginName) throws ServiceException;
   public void lockOpers(List<Oper> opers,Integer status) throws ServiceException;
   public void editOper(Oper oper) throws ServiceException;
}
