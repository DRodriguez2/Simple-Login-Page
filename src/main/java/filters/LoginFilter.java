package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import hibernateClasses.HibernateUtil;
import hibernateClasses.UserEntity;

@WebFilter(urlPatterns = { "/Login" })
public class LoginFilter implements Filter {
	
	private  final static Logger Logger = LogManager.getLogger(LoginFilter.class);
	
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
			Logger.trace("marker 1");
			request.setAttribute("result", "<SPAN style='color:red'>User name or password fields cannot be empty</SPAN>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		UserEntity user;
		if((user =  session.get(UserEntity.class, username)) ==  null) {
			Logger.trace("marker 2");
			request.setAttribute("result", "<SPAN style='color:red'>User name does not exist</SPAN>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			session.close();
			return;
		} else if(!(password.equals(user.getPassword()))){
			Logger.trace("marker 3");
			request.setAttribute("result", "<SPAN style='color:red'>Incorrect password</SPAN>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			session.close();
			return;
		}
		session.close();
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
