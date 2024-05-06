package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ModelDAO;
import model.UserDetails;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails ud = new UserDetails();
		
		ud.setName(request.getParameter("uname"));
		ud.setNumber(request.getParameter("unumber"));
		ud.setEmail(request.getParameter("uemail"));
		ud.setPassword(request.getParameter("upassword"));
		
		ModelDAO dao = new ModelDAO();
		
		try {
			
			int num = dao.signUpUser(ud);
			if (num >= 1) {
				response.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
