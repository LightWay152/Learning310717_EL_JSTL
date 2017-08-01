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

import eshop.entity.Customer;
import eshop.entity.EShopV10;

@WebServlet("/user-list.php")
public class UserListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session = EShopV10.openSession();
		String hql = "FROM Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		
		req.setAttribute("users", list);
		req.getRequestDispatcher("user-list.jsp").forward(req, resp);
	}
}
