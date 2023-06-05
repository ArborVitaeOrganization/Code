package controller; 
 
import java.io.IOException; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import model.dao.TreeDao; 
 
/** 
 * Servlet implementation class catalogItemServlet 
 */ 
@WebServlet("/catalogItemServlet") 
public class CatalogItemServlet extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
        
    public CatalogItemServlet() { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
 
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
  String treeName=request.getParameter("treeName"); 
  if(treeName==null) { 
   //ritornare pagina di errore 
   return; 
  } 
  else { 
   TreeDao tD=new TreeDao(); 
   request.setAttribute("treeObject",tD.doRetrieveByInformations(treeName, null, null, null).get(0) ); 
   RequestDispatcher reqDisp= getServletContext().getRequestDispatcher("/view/item.jsp"); 
   reqDisp.forward(request, response); 
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