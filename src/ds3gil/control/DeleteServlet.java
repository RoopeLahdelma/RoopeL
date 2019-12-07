package ds3gil.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds3.model.dao.ds3DAO;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete_weapon")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			int id = new Integer(idStr);
			ds3DAO ds3dao = new ds3DAO();
			ds3dao.removeWeapon(id);
			
		} catch (SQLException e) {
				System.out.println("::Error happened:: " + e.getMessage());
		}
			response.sendRedirect("weapons");
	}

}
