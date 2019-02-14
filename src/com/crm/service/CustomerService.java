package com.crm.service;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.crm.dao.CustomerDao;
import com.crm.dao.Impl.CustomerDaoImpl;
import com.crm.domain.Customer;
import com.crm.utils.HibernateUtils;

public class CustomerService {
	private CustomerDao cDao = new CustomerDaoImpl();
	
	public void save(Customer c) {
		Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			cDao.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		tx.commit();
	}
	public List<Customer> getAll() {
		
		Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
		List<Customer>list = cDao.getAll();
		tx.commit();
		return list;
	}
	public List<Customer> getAll(DetachedCriteria dc) {
		
		Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
		List<Customer>list = cDao.getAll(dc);
		tx.commit();
		return list;
	}
}
