package com.cqut.minishop.util.jwt;

import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LJH
 * @date 2019/7/16-6:16
 * @QQ 1755497577
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/*
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("authorization");
        if( token == null){
            ((HttpServletResponse) servletResponse).sendRedirect("http://localhost:8080/minishop/user/login");
            return;
        }
        Claims claims = JwtService.parsePersonJWT(token);
        if (claims == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("http://localhost:8080/minishop/user/login");

        }else {
            filterChain.doFilter(request,response);
        }*/
    }

    @Override
    public void destroy() {

    }
}