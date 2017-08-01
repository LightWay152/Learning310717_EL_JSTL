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

@WebServlet("/cate-update.php")
public class CateUpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String nameVN =  req.getParameter("nameVN");
		
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setNameVN(nameVN);
		
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(category);
			t.commit();
			req.setAttribute("message", "Update successfully!");
		} catch (Exception e) {
			t.rollback();
			req.setAttribute("message", "Update failed!");
		}
		req.getRequestDispatcher("category.php").forward(req, resp);
	}
}
