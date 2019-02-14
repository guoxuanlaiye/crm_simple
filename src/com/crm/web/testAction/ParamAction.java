package com.crm.web.testAction;

import com.opensymphony.xwork2.ActionSupport;

public class ParamAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	@Override
	public String execute() throws Exception {
		System.out.println("name = "+name);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
