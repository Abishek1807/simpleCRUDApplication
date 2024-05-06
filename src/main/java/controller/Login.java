package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ModelDAO;
import model.UserDetails;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		ModelDAO dao = new ModelDAO();
		
		try {
			
			boolean result = dao.loginUser(userName, password);
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionName", userName); // Use this as sessionEmail as well
				
				UserDetails ud = dao.getUserDetails(userName);
				session.setAttribute("sessionUname", ud.getName());
				session.setAttribute("sessionNumber", ud.getNumber());
				session.setAttribute("sessionPassword", ud.getPassword());
				
				response.sendRedirect("welcome.jsp");
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
