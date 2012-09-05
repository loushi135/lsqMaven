package com.lsq.common.util;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
@Component("QueryUtil")
public class QueryUtil extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List queryKeShi(DetachedCriteria dc) {
		// TODO Auto-generated method stub	
		List list=getHibernateTemplate().findByCriteria(dc);
		return list;
	}
}
