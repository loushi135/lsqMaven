package com.lsq.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsq.common.exception.DaoException;
import com.lsq.common.util.PaginationSortOrderData;
import com.lsq.dao.BaseDao;
import com.lsq.model.BaseTO;

/**
 * DAO基类
 * 
 */
@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public Session getSession() {
		if(sessionFactory!=null){
			if(sessionFactory.getCurrentSession()!=null){
				return sessionFactory.getCurrentSession();
			}else{
				return sessionFactory.openSession();
			}
		}
		return null;
	}

	/**
	 * 保存实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editSave(BaseTO oTO) throws DaoException {
		try {
			getSession().save(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 修改实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void editUpdate(BaseTO oTO) throws DaoException {
		try {
			getSession().update(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 保存或修改实�?
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void edit(BaseTO oTO) throws DaoException {
		try {
			getSession().saveOrUpdate(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	/**
	 * 删除实例
	 * 
	 * @param oTO
	 * @throws DaoException
	 */
	public void delete(BaseTO oTO) throws DaoException {
		try {
			getSession().delete(oTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List queryAll(String hql) throws DaoException {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql)
				.list();// 使用了setCacheable(true)才成�?
											// query.setCacheRegion("myCacheRegion");//指定要使用的cacheRegion，可�?
		// query.setCacheRegion("myCacheRegion");指定要使用的cacheRegion是myCacheRegion，即你可以给每个查询缓存做一个单独的配置，使用setCacheRegion来做这个指定，需要在ehcache.xml里面配置�?
	}

	@SuppressWarnings("unchecked")
	@Override
	public List search(String keyword) {

		FullTextSession fullTextSession = Search.getFullTextSession(getSession());
		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query
		// parser
		// or the Lucene programmatic API. The Hibernate Search DSL is
		// recommended though
//		SearchFactory searchFactory = fullTextSession.getSearchFactory();
//		searchFactory.optimize(User.class);
//		try {
//			fullTextSession.createIndexer(User.class).startAndWait();//fullTextSession.createIndexer()对所有的@index的对像创建索引
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		QueryBuilder qb = fullTextSession.getSearchFactory()
//				.buildQueryBuilder().forEntity(User.class).get();
//		org.apache.lucene.search.Query query = qb.keyword().onFields(
//				"username","name").matching(keyword).createQuery();
//		// wrap Lucene query in a org.hibernate.Query
//		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
//				query, User.class);
//		// execute search
//		List result = hibQuery.list();
//		try{
//	        QueryParser parser = new QueryParser(Version.LUCENE_34,"dept_name", new StopAnalyzer(Version.LUCENE_34));
//	        org.apache.lucene.search.Query luceneQuery = parser
//	                .parse("menuName:menu");
//	        org.hibernate.Query hibQuery1 = fullTextSession.createFullTextQuery(luceneQuery,
//	                Menu.class);
//	        List list = hibQuery.list();
//	        System.out.println(list.size());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		//高亮设置
//		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter( "<b><font color=\"red\">", "</font></b>");   
//		QueryScorer qs = new QueryScorer(query);
//		Highlighter highlighter = new Highlighter( formatter, qs);
//		List list = new ArrayList();
//		for(int i=0;i<result.size();i++){
//			String name = "";
//			User user = (User)result.get(i);
//			Analyzer analyzer = new IKAnalyzer();  
//			try {
//				name = highlighter.getBestFragment(analyzer, keyword,user.getName() );
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidTokenOffsetsException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			User u = new User();
//		   	u.setName(name);
//			list.add(u);//直接用user.setName(name)，因为此user是持久态的，这样的话不用save(user)也会进行保存的
//		}
//		 Object fieldValue = ReflectionUtils.invokeMethod(
//				 BeanUtils.getPropertyDescriptor(searchResultClass, fieldName).getReadMethod(), e);
//		return list;
		return null;
	}
	

	@Override
	public void createIndex() {
		// TODO Auto-generated method stub
		FullTextSession fullTextSession = Search.getFullTextSession(getSession());
		try {
			//fullTextSession.createIndexer(User.class).startAndWait();
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAll(Collection<BaseTO> entities) throws DaoException {
		// TODO Auto-generated method stub
		for (Iterator iterator = entities.iterator(); iterator.hasNext();) {
			BaseTO baseTO = (BaseTO) iterator.next();
			getSession().delete(baseTO);
		}
	}

	@Override
	public PaginationSortOrderData findWithPage(DetachedCriteria dc,
			PaginationSortOrderData page) throws DaoException {
		try {
			Criteria criteria = dc.getExecutableCriteria(getSession());// 生成Criteria
			Long rowCount = (Long) criteria.setProjection(
					Projections.rowCount()).uniqueResult();
			if(rowCount!=null){
				page.setRowCount(Integer.valueOf(rowCount+""));// 查询得到数据总数并存入分页JavaBean
			}else{
				page.setRowCount(0);// 查询得到数据总数并存入分页JavaBean
			}
			criteria.setProjection(null);
			criteria.setFirstResult(page.getPageSize()
					* (page.getCurPage() - 1));
			criteria.setMaxResults(page.getPageSize());
			String sortValue = page.getSortValue();
			this.setOrderCriteriaBySortValue(criteria,sortValue,page);
//			if (!StringUtils.isEmpty(sortValue)){
//				if (page.isHasAscing()) {
//					criteria.createCriteria("workInfo").addOrder(Order.asc("nowCompany"));
//				} else {
//					criteria.createCriteria("workInfo").addOrder(Order.desc("nowCompany"));
//				}
//			}
//			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
			page.setDataList(criteria.list());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
//		finally{
//			page.setDefaultSortValue("");
//			page.setHasAscing(false);
//			page.setSortValue("");
//		}
		return page;
	}

	/**
	 * @param criteria 给此对象 加criteria.createCriteria(obj);
	 * @param sortValue 返回要排序的字段
	 * @return
	 */
	private void setOrderCriteriaBySortValue(Criteria criteria,String sortValue,PaginationSortOrderData page){
		if(StringUtils.isNotBlank(sortValue)){
			if(sortValue.contains(".")){
				String obj = sortValue.substring(0, sortValue.indexOf(".", 0));//String.indexOf(String str, int fromIndex) 从fromIndex开始找到第一个str的位置
				String nextStr = sortValue.substring(sortValue.indexOf(".", 0)+1);
				if(nextStr.contains(".")){
					criteria.createCriteria(obj,JoinType.FULL_JOIN);
					setOrderCriteriaBySortValue(criteria,nextStr,page);
				}else{
					if (page.isHasAscing()) {
						criteria.createCriteria(obj,JoinType.FULL_JOIN).addOrder(Order.asc(nextStr));
					} else {
						criteria.createCriteria(obj,JoinType.FULL_JOIN).addOrder(Order.desc(nextStr));
					}
				}
			}else{
				if (page.isHasAscing()) {
					criteria.addOrder(Order.asc(sortValue));
				} else {
					criteria.addOrder(Order.desc(sortValue));
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List query(DetachedCriteria dc) throws DaoException {
		Criteria criteria = dc.getExecutableCriteria(getSession());// 生成Criteria
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	//根据单个条件查询
	public List query(String hql, Object parameter) throws DaoException {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		query.setParameter(0, parameter);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List query(String hql, Object[] parameter) throws DaoException {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		int i = 0;
		for(Object obj:parameter){
			query.setParameter(i, obj);
			i++;
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List query(String hql) throws DaoException {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List queryAll(Class clazz) throws DaoException {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(clazz);
		return criteria.list();
	}


	@Override
	public Object queryOne(DetachedCriteria dc) throws DaoException {
		// TODO Auto-generated method stub
		Criteria criteria = dc.getExecutableCriteria(getSession()); 
		return criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BaseTO queryOne(Class clazz, Serializable id) throws DaoException {
		// TODO Auto-generated method stub
		return (BaseTO)getSession().load(clazz,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List querySQL(String sql, Object[] param) throws DaoException {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(sql);
		int i = 0;
		for(Object obj:param){
			query.setParameter(i, obj);
			i++;
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PaginationSortOrderData findEntityListByHqlMap(String hql, Map map,
			PaginationSortOrderData page) throws DaoException {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		  if(map!=null){
				if(!map.isEmpty()){
					 Set<Entry<String, Object>> entrySet= map.entrySet();
					 for (Entry<String, Object> entry:entrySet) {
						  query.setParameter(entry.getKey(), entry.getValue());
					  }
				}
			}
	  	//在用的地方先用这�? page.setRowCount(findEntityCountByHqlMap(hql,map));// 查询得到数据总数并存入分页JavaBean
		query.setFirstResult(page.getPageSize() * (page.getCurPage() - 1));
		query.setMaxResults(page.getPageSize());
		return page;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int findEntityCountByHqlMap(String hql, Map map) {
		Query query = getSession().createQuery(hql);
		if(map!=null){
			if(!map.isEmpty()){
			 Set<Entry<String, Object>> entrySet= map.entrySet();
			 for (Entry<String, Object> entry:entrySet) {
				  query.setParameter(entry.getKey(), entry.getValue());
			  }
			}
		}
		List<Integer> list = query.list();//
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

}
