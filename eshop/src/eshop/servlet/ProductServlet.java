package eshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import eshop.entity.EShopV10;
import eshop.entity.Product;

@WebServlet("/product.php")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session =EShopV10.openSession();
		String hql = "FROM Product";
		Query query =session.createQuery(hql);
		List<Product> list = query.list();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}
}
