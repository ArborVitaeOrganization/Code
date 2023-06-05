package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
    public static String log;
    public LoginServlet() {
        super();
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UserDao ud = new UserDao();
    
    HttpSession sessione = request.getSession();
    User u = ud.doLogin(email, password);
    if(u==null){
      sessione.setAttribute("logged", "false");
      response.sendRedirect("/ArborVitae/view/login.jsp"); 
      return;
    }else {
    	sessione.setAttribute("logged", "true");
    	sessione.setAttribute("email", email);
    	sessione.setAttribute("isName", u.getName());
    	sessione.setAttribute("isSurname", u.getSurname());
    	if(u.getRole().equals(User.userRole.User)) {
    		if(sessione.getAttribute("previous")==null) {
    			response.sendRedirect("/ArborVitae/view/homepage.jsp");
    		}else {
    			String uri=(String)sessione.getAttribute("previous");
    			//uri=uri.replace("/ArborVitae","");
    			response.sendRedirect(uri);
    		}
    	}else {
    		if(sessione.getAttribute("previous")==null) {
    			response.sendRedirect("/ArborVitae/admin/admin.jsp");
    		}else {
    			String uri=(String)sessione.getAttribute("previous");
    			//uri=uri.replace("/ArborVitae","");
    			response.sendRedirect(uri);
    		}
    	}
    }

  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}