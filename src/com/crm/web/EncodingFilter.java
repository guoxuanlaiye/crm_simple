package com.crm.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
 * 解决全局中文编码问题
 * @author guoxuan
 * */
public class EncodingFilter implements Filter {
	public EncodingFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		StrongRequest strongRequest = new StrongRequest(req);
		chain.doFilter(strongRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}

class StrongRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private boolean hasEncode;

	public StrongRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	/*
	 * getParameter
	 * */
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0]; // 取回参数的第一个值
	}

	@Override
	/*
	 * getParameterValues
	 * */
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}

	@Override
	/*
	 * getParameterMap
	 * */
	public Map<String, String[]> getParameterMap() {
		// 先获得请求方式
		String method = this.request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			System.out.println("-------POST=====");
			// post请求
			try {
				// 处理post乱码
				this.request.setCharacterEncoding("utf-8");
				return this.request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (method.equalsIgnoreCase("get")) {
			// get请求
			Map<String, String[]> parameterMap = this.request.getParameterMap();
			if (!hasEncode) { // 确保get手动编码逻辑只运行一次
				for (String parameterName : parameterMap.keySet()) {
					String[] values = parameterMap.get(parameterName);
					if (values != null) {
						for (int i = 0; i < values.length; i++) {
							try {
								// 处理get乱码
								values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return parameterMap;
		}
		return super.getParameterMap();
	}
}
