package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ModelDAO;

@WebServlet("/deleteAccount")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionUserName = (String) session.getAttribute("sessionName");
		
		ModelDAO dao = new ModelDAO();
		try {
			int result = dao.deleteAccount(sessionUserName);
			if (result == 1) {
				Logout logout = new Logout();
				logout.doPost(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
