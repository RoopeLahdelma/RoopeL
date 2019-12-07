package ds3gil.control;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds3.model.dao.ds3DAO;
import ds3gil.model.WeaponList;




@WebServlet("/weapons")
public class DS3GIL_WeaponList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	

		ds3DAO weapondao = new ds3DAO();
		ArrayList<WeaponList> weapons = weapondao.findAll();		
		request.setAttribute("weapons", weapons);
		
		
	
		String jsp = "/view/listweapons.jsp"; 
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	
	}
	

}
