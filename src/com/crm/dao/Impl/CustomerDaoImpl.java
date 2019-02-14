package com.crm.dao.Impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	@Override
	public void update(Customer customer) {
		
	}

	@Override
	public void delete(Long cust_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		String hql = "from com.crm.domain.Customer";
		Query<Customer> query = session.createQuery(hql);
		List<Customer> list = query.list();
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
	}
}
