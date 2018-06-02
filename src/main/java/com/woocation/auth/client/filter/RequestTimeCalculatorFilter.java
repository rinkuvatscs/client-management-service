package com.woocation.auth.client.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestTimeCalculatorFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestTimeCalculatorFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long startTime = System.currentTimeMillis();

		chain.doFilter(request, response);

		LOGGER.info("Authentication DashBoard Service Request completed for Url {} with {} ms time with Response Status {} ",
				((HttpServletRequest) request).getRequestURI(), (System.currentTimeMillis() - startTime),
				((HttpServletResponse) response).getStatus());

	}

	@Override
	public void destroy() {
	}

}
