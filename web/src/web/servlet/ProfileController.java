package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile.php")
public class ProfileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		if(httpSession.getAttribute("user")==null){//have not login
			resp.sendRedirect("login.php");
		}
		else{
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		}
	}
}
