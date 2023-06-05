package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDao;

/**
 * Servlet implementation class AggiungiServlet
 */
@WebServlet(name="aggAdmin", urlPatterns="/aggAdmin")
public class AggiungiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AggiungiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDao();
		HttpSession sessione = request.getSession();
		String email = request.getParameter("newEmail");
		String name = request.getParameter("newName");
		String surname = request.getParameter("newSurname");
		String country = request.getParameter("newCountry");
		String pass = request.getParameter("newPass");
		User u = new User(email, name, surname, country, pass, User.userRole.Admin);
		try {
			boolean yes= ud.doSave(u);
			if(yes==false) 
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/aggiungiAdmin.jsp");
	        	rd.forward(request, response);
				return;
			}else 
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/ArborVitae/gestione?id=" + 1);
	        	rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
