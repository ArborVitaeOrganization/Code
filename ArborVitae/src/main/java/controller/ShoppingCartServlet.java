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

import model.bean.ShoppingCart;
import model.bean.Tree;
import model.dao.ShoppingCartDao;
import model.dao.TreeDao;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ShoppingCartServlet() {
        super();
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	String treeNameToRemove= request.getParameter("tRemove");
	if(treeNameToRemove!=null) {
		TreeDao tD=new TreeDao(); 
	    Tree t=tD.doRetrieveByInformations(treeNameToRemove, null, null, null).get(0); 
	    HttpSession userSession= request.getSession(); 
	    String email=(String)userSession.getAttribute("email");
	    if(email==null) { 
			response.setStatus(201);
	     return; 
	    }else { 
	     ShoppingCartDao scD=new ShoppingCartDao(); 
	     ShoppingCart sC=scD.doRetrieveByKey(email);
	     if(sC==null) { 
	      scD.doAdd(email);
	      return;
	     } 
	     scD.doRemoveTree(sC.getcodeCart(),t.getCodeTree());
	     int numItems=scD.doRetrieveTrees(sC.getcodeCart()).size();
	     PrintWriter pw=response.getWriter();
	     pw.print(numItems);
	     response.setStatus(200); 
	     return; 
	    }
	}else if(request.getParameter("treeName")!=null){
		String treeNameToAdd=(String)request.getParameter("treeName"); 
		TreeDao tD=new TreeDao(); 
		Tree t=tD.doRetrieveByInformations(treeNameToAdd, null, null, null).get(0); 
		HttpSession userSession= request.getSession(); 
		String email=(String)userSession.getAttribute("email");
		if(email==null) { 
			response.setStatus(201);
			return; 
		}else { 
			ShoppingCartDao scD=new ShoppingCartDao(); 
			ShoppingCart sC=scD.doRetrieveByKey(email);
			if(sC==null) { 
				scD.doAdd(email); 
			} 
			scD.doAddTree(sC.getcodeCart(),t.getCodeTree());
			int numItems=scD.doRetrieveTrees(sC.getcodeCart()).size();
			PrintWriter pw=response.getWriter();
			pw.print(numItems);
			response.setStatus(200);
			return; 
		} 
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