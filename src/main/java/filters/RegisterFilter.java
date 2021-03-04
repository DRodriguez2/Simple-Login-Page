package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;

import hibernateClasses.HibernateUtil;
import hibernateClasses.UserEntity;

@WebFilter(urlPatterns = {"/Register"})
public class RegisterFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		
		if(username == null || password == null || verify == null || username.isEmpty() || password.isEmpty() || verify.isEmpty()) {
			request.setAttribute("result", "<SPAN style='color:red'>Fields cannot be empty</SPAN>");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		if(!(session.get(UserEntity.class, username) == null)) {
			request.setAttribute("result", "<SPAN style='color:red'>User name already exists</SPAN>");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			session.close();
			return;
		} else if(!(password.equals(verify))) {
			request.setAttribute("result", "<SPAN style='color:red'>Passwords do not match</SPAN>");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			session.close();
			return;
		}
		session.close();
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
