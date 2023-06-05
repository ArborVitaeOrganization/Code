package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Tree;
import model.dao.TreeDao;

/**
 * Servlet implementation class CatalogoServlet
 */
@WebServlet(name="catalogoServlet", urlPatterns="/catalogoServlet")
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CatalogoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("ricerca")==null) {
			int i = Integer.parseInt(request.getParameter("ordinamento"));
			TreeDao td = new TreeDao();
			HttpSession sessione = request.getSession();
			ArrayList<Tree> list = td.doRetrieveTree(i);
			sessione.setAttribute("tree", list);
			response.sendRedirect("/ArborVitae/view/catalog.jsp");
			return;
		}
		else {
			String name=(String)request.getParameter("ricerca");
			TreeDao td = new TreeDao();
			HttpSession sessione = request.getSession();
			ArrayList<Tree> list = td.doRetrieveByInformations(name,null, null, null);
			sessione.setAttribute("tree", list);
			response.sendRedirect("/ArborVitae/view/catalog.jsp");
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
