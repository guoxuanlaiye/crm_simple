package com.crm.web.action;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.crm.domain.Customer;
import com.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	private CustomerService cs = new CustomerService();
	// 模型驱动
	private Customer customer = new Customer();
	
	
	/*
	 * 用户名模糊查询
	 * */
	public String query() throws Exception {
		/*
		 * 1、接收参数
		 * 2、创建离线查询对象
		 * 3、判断参数拼装条件
		 * 4、调用service将离线对象传递
		 * 5、将返回的list放入request域中，转发到list.jsp
		 * */
//		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		List<Customer>list = cs.getAll(dc);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	/*
	 * 获取全部客户
	 * */
	public String list() throws Exception {
		List<Customer>list = cs.getAll();
		ActionContext.getContext().put("list", list);
		return "list";
	}
	/*
	 * 添加用户
	 * */
	public String add() throws Exception {
		// TODO Auto-generated method stub
		cs.save(customer);
		return "toList";
	}
	@Override
	public Customer getModel() {
		return customer;
	}
}
