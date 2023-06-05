package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.ShoppingCartDao;
import model.dao.UserDao;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name="signup", urlPatterns="/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String log;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
	    String country = request.getParameter("country");
	    String password = request.getParameter("password");
	    User u = new User(email, name, surname, country, password, User.userRole.User);
	    HttpSession sessione = request.getSession();
	    UserDao ud = new UserDao();
	    try {
			boolean login= ud.doSave(u);
			if(login==false) {
				sessione.setAttribute("logged", "false");
				response.sendRedirect("view/signup.jsp");
				return;
			}
			else {
				log = u.getName();
				sessione.setAttribute("logged", "true");
				sessione.setAttribute("utente", u);
		    	sessione.setAttribute("isName", u.getName());
		    	sessione.setAttribute("isSurname", u.getSurname());
		    	ShoppingCartDao scD = new ShoppingCartDao();
		    	scD.doAdd(email);
				String ind = (String) sessione.getAttribute("previous");
				sessione.setAttribute("email", email);			
				if(ind == null) {
					response.sendRedirect("view/homepage.jsp");
					return;
				}
				
				else if(ind.equals("/ArborVitae/catalogoServlet")) {
					response.sendRedirect(ind+"?ordinamento=1");
					return;
				}
				response.sendRedirect(ind);
			}
		} catch (SQLException e) {
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
