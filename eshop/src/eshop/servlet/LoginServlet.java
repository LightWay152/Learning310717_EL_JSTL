package eshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import eshop.entity.Customer;
import eshop.entity.EShopV10;

@WebServlet("/login.php")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		Session session = EShopV10.openSession();
		
		try {
			Customer user = (Customer) session.get(Customer.class, id);			
			if(pw.equals(user.getPassword())){
				req.setAttribute("message", "Login successfully!");
			}
			else{
				req.setAttribute("message", "Invalid password!");
			}
		} catch (Exception e) {
			req.setAttribute("message", "Invalid username!");
		}
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
