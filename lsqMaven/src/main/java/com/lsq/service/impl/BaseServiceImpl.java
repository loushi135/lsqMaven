package com.lsq.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsq.common.exception.DaoException;
import com.lsq.common.util.PaginationSortOrderData;
import com.lsq.dao.BaseDao;
import com.lsq.model.BaseTO;
import com.lsq.service.BaseService;

@Service("baseService")
//@Transactional
public class BaseServiceImpl implements BaseService {
	@Autowired
	private BaseDao baseDao;
	@Override
	public void delete(BaseTO oto) throws DaoException {
		// TODO Auto-generated method stub
		baseDao.delete(oto);
	}

	@Override
	public void edit(BaseTO oto) throws DaoException {
		// TODO Auto-generated method stub
		baseDao.edit(oto);
	}

	@Override
	public void editSave(BaseTO oto) throws DaoException {
		// TODO Auto-generated method stub
		baseDao.editSave(oto);
	}

	@Override
	public void editUpdate(BaseTO oto) throws DaoException {
		// TODO Auto-generated method stub
		baseDao.editUpdate(oto);
	}

	@Override
	public List queryAll(String hql) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.queryAll(hql);
	}

	@Override
	public List doSearch(String keyword) {
		// TODO Auto-generated method stub
		return baseDao.search(keyword);
	}
	

	@Override
	public void createIndex() {
		// TODO Auto-generated method stub
		baseDao.createIndex();
	}

	@Override
	public void deleteAll(Collection<BaseTO> entities) throws DaoException {
		// TODO Auto-generated method stub
		 baseDao.deleteAll(entities);
	}

	@Override
	public int findEntityCountByHqlMap(String hql, Map map) {
		// TODO Auto-generated method stub
		return baseDao.findEntityCountByHqlMap(hql, map);
	}

	@Override
	public PaginationSortOrderData findEntityListByHqlMap(String hql, Map map,
			PaginationSortOrderData page) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.findEntityListByHqlMap(hql, map, page);
	}

	@Override
	public PaginationSortOrderData findWithPage(DetachedCriteria dc,
			PaginationSortOrderData page) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.findWithPage(dc, page);
	}

	@Override
	public List query(DetachedCriteria dc) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.query(dc);
	}

	@Override
	public List query(String hql, Object parameter) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.query(hql, parameter);
	}

	@Override
	public List query(String hql, Object[] parameter) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.query(hql, parameter);
	}

	@Override
	public List query(String hql) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.query(hql);
	}

	@Override
	public List queryAll(Class clazz) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.queryAll(clazz);
	}

	@Override
	public BaseTO queryOne(Class clazz, Serializable id) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.queryOne(clazz, id);
	}

	@Override
	public List querySQL(String sql, Object[] param) throws DaoException {
		// TODO Auto-generated method stub
		return baseDao.querySQL(sql, param);
	}

	
}
