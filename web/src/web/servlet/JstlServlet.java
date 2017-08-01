package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl.php")
public class JstlServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("year", 2004);
		
		req.setAttribute("hours", 15);

		List<String> list = new ArrayList<String>();
		list.add("Tuan");
		list.add("Cuong");
		list.add("Hanh");
		list.add("Kien");
		list.add("Phuong");
		list.add("Hong");
		req.setAttribute("list", list);
		
		req.setAttribute("num1", 1000000.12345);
		req.setAttribute("num2", 0.56);
		req.setAttribute("now", new Date());
		
		req.getRequestDispatcher("jstl.jsp").forward(req, resp);
	}
}
