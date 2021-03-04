package Servlets;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import hibernateClasses.HibernateUtil;
import hibernateClasses.UserEntity;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		UserEntity user = new UserEntity(request.getParameter("username"),  request.getParameter("password"));
		session.save(user);
		try {
			session.getTransaction().commit();
			session.close();
			response.sendRedirect("index.jsp?registerSuccess=true");
		} catch (RollbackException e) {
			session.close();
			response.sendRedirect("index.jsp?registerSuccess=false");
		}
	}

}
