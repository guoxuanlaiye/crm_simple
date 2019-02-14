package com.crm.web.testAction;

import com.crm.domain.test.User;
import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport{
	/**
	 * 对象驱动
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public String execute() throws Exception {
		System.out.println(user.toString());
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
