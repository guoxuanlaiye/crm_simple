package com.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.crm.domain.Customer;

public interface CustomerDao {
	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(Long cust_id);
	public List<Customer> getAll();
	public List<Customer> getAll(DetachedCriteria dc);
}
