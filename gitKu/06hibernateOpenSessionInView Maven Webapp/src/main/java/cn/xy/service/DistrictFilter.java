package cn.xy.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.classic.Session;

import cn.xy.util.SessionFactoryUtil;
@WebFilter("/*")
public class DistrictFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
			Session session = SessionFactoryUtil.getCurrentSession();
			session.beginTransaction();
			System.out.println("过滤器中的"+session.hashCode());
			filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
