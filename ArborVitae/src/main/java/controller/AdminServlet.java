package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Orders;
import model.bean.Products;
import model.bean.Tree;
import model.bean.User;
import model.dao.OrdersDao;
import model.dao.TreeDao;
import model.dao.UserDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "gestione", urlPatterns = "/gestione")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		if (i == 5) {
			UserDao ud = new UserDao();
			String email = request.getParameter("newEmail");
			String name = request.getParameter("newName");
			String surname = request.getParameter("newSurname");
			String country = request.getParameter("newCountry");
			String pass = request.getParameter("newPass");
			User u = new User(email, name, surname, country, pass, User.userRole.Admin);
			try {
				boolean yes = ud.doSave(u);
				if (yes == false) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/aggiungiAdmin.jsp");
					rd.forward(request, response);
					return;
				} else {
					i = 1;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (i == 11) {
			TreeDao td = new TreeDao();
			String nome = request.getParameter("name");
			String des = request.getParameter("newDes");
			if (des == "")
				des = null;
			String p = request.getParameter("newPrice");
			double price;
			if (p == "")
				price = 0;
			else
				price = Double.parseDouble(p);
			boolean yes = td.doUpdate(nome, des, price);
			if (yes == false) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/modificaAlberi.jsp");
				rd.forward(request, response);
			} else
				i = 3;
		}
		if (i == 6) {
			TreeDao ud = new TreeDao();
			String nome = request.getParameter("newName");
			String spe = request.getParameter("newSpecie");
			String paese = request.getParameter("newCountry");
			String co2 = request.getParameter("newco2");
			String des = request.getParameter("newDes");
			double prezzo = Double.parseDouble(request.getParameter("newPrice"));
			String path = request.getParameter("newPath");
			boolean yes = ud.doAdd(nome, spe, paese, co2, des, prezzo);
			if (yes == false) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/aggiungiAlberi.jsp");
				rd.forward(request, response);
				return;
			} else {
				i = 3;
			}
		}
		if (i == 7 || i == 8) {
			UserDao ud = new UserDao();
			String s = request.getParameter("em");
			ud.doDelete(s);
			if (i == 7)
				i = 1;
			else
				i = 2;
		}

		if (i == 10) {
			TreeDao td = new TreeDao();
			String j = request.getParameter("code");
			td.doDelete(j);
			i = 3;
		}

		if (i == 1 || i == 2) {
			UserDao ud = new UserDao();
			HttpSession sessione = request.getSession();
			ArrayList<User> list = ud.doRetriveRole(i);
			if (list.size() == 0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin.jsp");
				rd.forward(request, response);
				return;
			}
			sessione.setAttribute("utente", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/visualizzaAdmin.jsp");
			rd.forward(request, response);
		}
		if (i == 3) {
			TreeDao td = new TreeDao();
			HttpSession sessione = request.getSession();
			ArrayList<Tree> list = td.doRetrieveTree(1);
			ArrayList<Integer> code = td.doRetrieveCode();
			if (list.size() == 0 || code.size() == 0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin.jsp");
				rd.forward(request, response);
				return;
			}
			sessione.setAttribute("alberi", list);
			sessione.setAttribute("codice", code);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/visualizzaAlberi.jsp");
			rd.forward(request, response);
		}
		if (i == 4) {
			OrdersDao ud = new OrdersDao();
			HttpSession sessione = request.getSession();
			ArrayList<Products> list = ud.doRetrieveKey(null, null, null);
			ArrayList<Orders> o = ud.doRetrieveDate(null, null, null);
			if (list.size() == 0 || o.size()==0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin.jsp");
				rd.forward(request, response);
				return;
			}
			sessione.setAttribute("prodotti", list);
			sessione.setAttribute("ordini", o);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/visualizzaOrdini.jsp");
			rd.forward(request, response);
		}
		if (i == 9) {
			String name = request.getParameter("code1");
			HttpSession sessione = request.getSession();
			TreeDao td = new TreeDao();
			ArrayList<Tree> list = td.doRetrieveByInformations(name, null, null, null);
			sessione.setAttribute("albero", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/modificaAlberi.jsp");
			rd.forward(request, response);
		}
		if (i == 12) {
			OrdersDao ud = new OrdersDao();
			HttpSession sessione = request.getSession();
			String email = request.getParameter("email");
			String data1 = request.getParameter("data1");
			String data2 = request.getParameter("data2");
			if (email == "")
				email = null;
			if (data1 == "")
				data1 = null;
			if (data2 == "")
				data2 = null;
			ArrayList<Products> list = ud.doRetrieveKey(email, data1, data2);
			ArrayList<Orders> o = ud.doRetrieveDate(email, data1, data2);
			if (list.size() == 0 || o.size()==0) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin.jsp");
				rd.forward(request, response);
				return;
			}
			sessione.setAttribute("prodotti", list);
			sessione.setAttribute("ordini", o);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/visualizzaOrdini.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

