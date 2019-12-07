package ds3gil.control;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds3.model.dao.ds3DAO;
import ds3gil.model.WeaponList;



@WebServlet("/edit-weapon")
public class DS3editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
/**
  Aseiden päivitystä varten tehty doGet
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		String idStr = request.getParameter("id");
		int id = new Integer(idStr);
		ds3DAO ds3dao = new ds3DAO();
		WeaponList weapon = ds3dao.findWeapon(id);
		request.setAttribute("weapon", weapon);
		
		String jsp = "/view/editweapon.jsp";
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	} catch (SQLException e) {
		System.out.println("Error has occured " + e.getMessage());
	}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		int id = new Integer(idStr);
		String types = request.getParameter("types");
		String buildtype = request.getParameter("buildtype");
		String lisat = request.getParameter("lisat");
		WeaponList weapon = new WeaponList(id, types, buildtype, lisat);
		
		System.out.println("Updated weapon: " + weapon.toString());
		
		ds3DAO ds3dao = new ds3DAO();
		
		String errorcode = null;
		
		/**
		  Lähetetään päivitetyn aseen tiedot tietokantaan
		 */
		try {
			ds3dao.editWeapon(weapon);	
		} catch (Exception e) {
			errorcode = "Error occured";
		}
		if (errorcode != null) {
			String Teksti = URLEncoder.encode(errorcode, "UTF-8");
			response.sendRedirect("weapons" + Teksti);
		} else
			response.sendRedirect("weapons");
	}
}
