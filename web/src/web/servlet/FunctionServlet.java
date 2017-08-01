package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/function.php")
public class FunctionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message = "Sáng 1/8, trao đổi với VnExpress về việc thu hồi tài sản tham ô, tham nhũng có diễn ra thuận lợi khi ông Trịnh Xuân Thanh ra đầu thú, ông Phạm Trọng Đạt (Cục trưởng Cục phòng chống tham nhũng, Thanh tra Chính phủ) cho rằng, toàn bộ tài liệu thanh tra, dấu hiệu sai phạm của Trịnh Xuân Thanh được cơ quan thanh tra chuyển cho cơ quan điều tra. Trong trường hợp công an chứng minh được có tài sản tham ô, tham nhũng thì bắt buộc phải thu hồi.";

		req.setAttribute("msg", message);
		
		req.getRequestDispatcher("function.jsp").forward(req, resp);
	}
}
