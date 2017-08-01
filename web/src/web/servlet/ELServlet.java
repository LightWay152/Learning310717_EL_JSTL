package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.entity.Category;

@WebServlet("/el.php")
public class ELServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("x", 2017);
		
		HttpSession session = req.getSession();
		session.setAttribute("x", 2018);
		
		ServletContext application = req.getServletContext();
		application.setAttribute("x", 2019);
		
		//--Bean
		Category cate = new Category();
		cate.setName("Laptop");
		cate.setNameVN("Máy tính xách tay");
		
		req.setAttribute("bean", cate);
		
		//--Collection
		List<String> list = new ArrayList<String>();
		list.add("Nguyen Nghiem");
		list.add("Le Thi Huong Thao");
		req.setAttribute("cols", list);
		
		//--Map
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("Tuan",7.5);
		map.put("Huong",9.0);
		req.setAttribute("map", map);
		
		//--Parameters
		//run this servlet and pass param like this: ...?name=dao&age=22
		
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
