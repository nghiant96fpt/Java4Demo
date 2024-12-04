package com.fpoly.java4.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpFilter extends Filter {
    // Thuoc HttpFilter interface
    void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
	    throws IOException, ServletException;

    // Thuoc Filter interface
    @Override
    default void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;

	this.doFilter(req, resp, chain);
    }
}
