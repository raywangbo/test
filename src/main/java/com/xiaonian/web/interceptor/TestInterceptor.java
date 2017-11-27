package com.xiaonian.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter
{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("======TestInterceptor===afterHandle");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("======TestInterceptor===postHandle");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        /**
         * 要校验token可以在此校验
         * 返回true才能继续执行postHandle；若是返回false则跳过postHandle执行afterHandle
         */
        System.out.println("======TestInterceptor===preHandle");
        
//        request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/view/login_bak.jsp").forward(request,response);
//        response.sendRedirect("login_bak.jsp");
        return true;
    }

    
    
}
