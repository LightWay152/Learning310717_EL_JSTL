package eshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import eshop.entity.Category;
import eshop.entity.EShopV10;

@WebServlet("/cate-edit.php")
public class CateEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Session session = EShopV10.openSession();
		Category category = (Category) session.get(Category.class, id);
		req.setAttribute("model", category);
		
		req.getRequestDispatcher("category.php").forward(req, resp);
	}
}
