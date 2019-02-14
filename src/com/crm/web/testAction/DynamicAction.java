package com.crm.web.testAction;

import com.opensymphony.xwork2.ActionContext;

public class DynamicAction {
	public String add() {
		ActionContext.getContext().put("name", "add");
		return "success";
	}
	public String delete() {
		ActionContext.getContext().put("name", "delete");
		return "success";
	}
	public String query() {
		ActionContext.getContext().put("name", "query");
		return "success";
	}
	public String update() {
		ActionContext.getContext().put("name", "update");
		return "success";
	}
}
