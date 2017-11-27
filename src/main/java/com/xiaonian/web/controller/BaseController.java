package com.xiaonian.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/admin/forward/{path:[a-zA-Z]+}_{jspName:[a-zA-Z]+}", method = RequestMethod.GET)
	public String forward(@PathVariable String path, @PathVariable String jspName) {
		return path + "/" + jspName;
	}
	
	@RequestMapping(value = "/wstest/{path:[a-zA-Z]+}_{api:[a-zA-Z]+}", method = RequestMethod.GET)
	public String wstest(@PathVariable String path, @PathVariable String api) {
		return "wstest/" + path + "/" + api;
	}
	
	@RequestMapping("/admin/export/check/{state}")  
	 public @ResponseBody boolean check(@PathVariable String state)  
	 {  
        if ("open".equals(request.getSession().getAttribute(state)))  
        {  
            request.getSession().setAttribute(state, null);  
            return true;
        }
        return false;
	 }
}
