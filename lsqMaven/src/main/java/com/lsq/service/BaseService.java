package com.lsq.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.lsq.common.exception.DaoException;
import com.lsq.common.util.PaginationSortOrderData;
import com.lsq.model.BaseTO;

public interface BaseService {

	/**
	 * 保存实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editSave(BaseTO oTO) throws DaoException;
	
	/**
	 * 修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editUpdate(BaseTO oTO) throws DaoException;
	
	/**
	 * 保存或修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void edit(BaseTO oTO) throws DaoException;

	/**
	 * 删除实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void delete(BaseTO oTO) throws DaoException;
	
	public List queryAll(String hql) throws DaoException;
	
	public List doSearch(String keyword);
	
	public void createIndex();
	
	/**
	 * 删除多个实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	 
	public void deleteAll(Collection<BaseTO> entities) throws DaoException;
	/**
	 * 取得一个实例
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public BaseTO queryOne(Class clazz, Serializable id) throws DaoException;

	/**
	 * 查找所有实例
	 * 
	 * @param clazz
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List queryAll(Class clazz) throws DaoException;

	/**
	 * hql语句查询,不带参数
	 * 
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List query(String hql) throws DaoException;

	/**
	 * hql语句查询,带一个参数
	 * 
	 * @param hql
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List query(String hql, Object parameter) throws DaoException;

	/**
	 * hql语句查询,带多个参数
	 * 
	 * @param hql
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List query(String hql, Object[] parameter) throws DaoException;

	
	/**
	 * DetachedCriteria方式查询
	 * 
	 * @param dc
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List query(final DetachedCriteria dc) throws DaoException;
	

	/**
	 * 使用纯sql查询<br>
	 * 
	 * @param param
	 * @throws DaoException
	 */
	public List querySQL(final String sql, final Object[] param)
			throws DaoException;
	
	/**
	 * 分页查询<br>
	 * 
	 * @param dc,page
	 * @param param
	 * @throws DaoException
	 */
	public PaginationSortOrderData findWithPage(
			final DetachedCriteria dc,final PaginationSortOrderData page) throws DaoException ;
	/**
	 * 
	 * @param hql hql查询语句
	 * @param map 所有的查询条件和值
	 * @param page
	 * @return
	 * @throws DaoException
	 */
	public PaginationSortOrderData findEntityListByHqlMap(String hql,Map map,PaginationSortOrderData page)throws DaoException ;

	/**
	 * 
	 * @param hql hql查询语句
	 * @param map 所有的查询条件和值
	 * @return
	 * @throws DaoException
	 */
	public int findEntityCountByHqlMap(String hql, Map map) ;
}
