package com.crm.web.testAction;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServletAPIAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String apiTest() {
		
		ActionContext.getContext().put("name", "Tom");
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "session scope");
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "application scope");
		return "success";
	}
}
