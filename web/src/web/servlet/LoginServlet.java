package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import web.entity.Customer;
import web.entity.EShopV10;

@WebServlet("/login.php")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();//get all cookies from client
		if(cookies != null){
			for(Cookie cki:cookies){
				String name = cki.getName();
				if(name.equals("uid")){
					String value = cki.getValue();
					System.out.println(value);
				}
			}
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String re = req.getParameter("remember");
		
		Session session = EShopV10.openSession();
		
		try {
			Customer user = (Customer) session.get(Customer.class, id);			
			if(pw.equals(user.getPassword())){
				/*Using session to manage user login or not -> security*/
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("user", user);
				
				req.setAttribute("message", "Login successfully!");
				
				/*Remember id, pass by cookie*/
				Cookie cookie_id = new Cookie("uid",id);
				Cookie cookie_pw = new Cookie("upw",pw);
				if(re != null){
					cookie_id.setMaxAge(30*24*60*60);
					cookie_pw.setMaxAge(30*24*60*60);
				}
				else{
					cookie_id.setMaxAge(0);//delete cookie id
					cookie_pw.setMaxAge(0);//delete cookie pass
				}
				resp.addCookie(cookie_id);
				resp.addCookie(cookie_pw);
				/*---------------------------*/
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
