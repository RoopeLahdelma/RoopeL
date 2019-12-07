package ds3gil.control;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds3.model.dao.ds3DAO;
import ds3gil.model.WeaponList;



@WebServlet("/new-category")
public class DS3GIL_newWeaponcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "/view/addweapons.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String types = request.getParameter("types"); 
		String buildtype = request.getParameter("buildtype"); 
		String lisat = request.getParameter("lisat"); 
	
		WeaponList weapon = new WeaponList(types, buildtype, lisat);

		ds3DAO weapondao = new ds3DAO();
		
		String virheteksti = null;
		try {
			weapondao.addWeapon(weapon);
		} catch (Exception e) {
			virheteksti = "Tapahtui tietokantavirhe.";
		}

		if (virheteksti != null) {
			String koodattuTeksti = URLEncoder.encode(virheteksti, "UTF-8");
		
			response.sendRedirect("weapons?viesti=" + koodattuTeksti);
		} else
			response.sendRedirect("weapons");
	}

}
