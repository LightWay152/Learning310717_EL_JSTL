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

@WebServlet("/cate-delete.php")
public class CateDeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Category category = new Category();
		category.setId(id);
		
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(category);
			t.commit();
			req.setAttribute("message", "Delete successfully!");
		} catch (Exception e) {
			t.rollback();
			req.setAttribute("message", "Delete failed!");
		}
		req.getRequestDispatcher("category.php").forward(req, resp);
	}
}
