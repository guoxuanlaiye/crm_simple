package com.crm.web.testAction;

import java.util.List;
import java.util.Map;

import com.crm.domain.test.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo2Action extends ActionSupport implements ModelDriven<User>{
	/**
	 * 模型驱动 继承ModelDriven，泛型为属性对象
	 */
	private static final long serialVersionUID = 1L;
	//	创建对象属性
	private User user = new User();
	// 集合类型
	private List<String> list;
	private Map<String, String>map;
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user.toString());
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}
}
