package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private  final static Logger Logger = LogManager.getLogger(Login.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("username"));
		response.sendRedirect("LandingPage.jsp");
	}

}
