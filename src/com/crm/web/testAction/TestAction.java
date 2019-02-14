package com.crm.web.testAction;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestAction {
	public String test1() {
		System.out.println("test1-----");
		return "success";
	}
	public String api() throws Exception {
		// struts2不推荐使用原生request域
//		Map<String, Object> requestScope = (Map<String, Object>) ActionContext.getContext().get("request");
		// 推荐直接放入到ActionContext域中
		ActionContext.getContext().put("name", "requestAttr");
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "sessionAttr");
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "applicationAttr");
		
		return "api";
	}
}
