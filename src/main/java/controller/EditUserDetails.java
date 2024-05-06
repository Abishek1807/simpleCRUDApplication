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

@WebServlet("/EditUserDetails")
public class EditUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String sessionEmail = (String) session.getAttribute("sessionName");
		
		UserDetails ud = new UserDetails();
		
		ud.setName(request.getParameter("name"));
		ud.setNumber(request.getParameter("number"));
		ud.setPassword(request.getParameter("password"));
		
		ModelDAO dao = new ModelDAO();
		
		try {
			int result = dao.editUserDetails(ud, sessionEmail);
			if (result == 1) {
//				response.getWriter().println("Your details were successfully modified");
				response.sendRedirect("profile.jsp");
			} else {
				// response.getWriter().println("Error modifying details. Try again!");
				response.sendRedirect("profile.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
