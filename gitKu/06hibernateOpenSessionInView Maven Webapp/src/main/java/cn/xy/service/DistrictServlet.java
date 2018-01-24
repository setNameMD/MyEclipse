package cn.xy.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xy.bean.District;
import cn.xy.dao.DistrictDao;
import cn.xy.dao.DistrictDaoImpl;
@WebServlet("/a")
public class DistrictServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DistrictDao dao=new DistrictDaoImpl();
		District id = dao.getDistrictById(1);
		req.setAttribute("a", id);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
