package eshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import eshop.entity.Customer;
import eshop.entity.EShopV10;

@WebServlet("/register.php")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req,resp);
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * Get Parameter
		 * */
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String photo = req.getParameter("photo");
		
		/*
		 * Create entity
		 * */
		Customer user = new Customer();
		user.setId(id);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPhoto(photo);
		user.setActivated(false);
		
		/*
		 * Insert database
		 * */
		Session session = EShopV10.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
			t.commit();
			req.setAttribute("message", "Register successfully!");
		} catch (Exception e) {
			t.rollback();
			req.setAttribute("message", "Register failed!");
		}
		req.getRequestDispatcher("register.jsp").forward(req,resp);
	}
}
