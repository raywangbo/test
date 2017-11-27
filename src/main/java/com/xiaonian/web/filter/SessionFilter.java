package com.xiaonian.web.filter;

import com.xiaonian.core.utils.ValidatorUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter extends OncePerRequestFilter
{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
	{
        String uri = request.getRequestURI();
    	Object object = request.getSession().getAttribute("user");
    	if(ValidatorUtil.isNotNull(object) || uri.endsWith("login.do"))
    	{
    		filterChain.doFilter(request, response);
    	}
    	else
    	{
    		request.getRequestDispatcher("WEB-INF/view/login_bak.jsp").forward(request,response);
    	}
	}
}
