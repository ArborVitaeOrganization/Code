package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.dao.OrdersDao;
import model.dao.ProductsDao;
import model.dao.ShoppingCartDao;
import model.dao.TreeDao;
import model.bean.Orders;
import model.bean.Products;
import model.bean.ShoppingCart;
import model.bean.Tree;

/**
 * Servlet implementation class InsertOrderServlet
 */
@WebServlet("/insertOrderServlet")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String treeName  = (String)request.getParameter("treeName");
			HttpSession session= request.getSession();
			String email = (String)session.getAttribute("email");
			if(treeName!=null) {
				if(email==null) {
					response.setStatus(201);
					return;
				}
				TreeDao tD= new TreeDao();
				Tree treeToBuy= tD.doRetrieveByInformations(treeName, null, null, null).get(0);
	            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	            LocalDateTime now = LocalDateTime.now();
	            System.out.println(dtf.format(now));
	            OrdersDao oD = new OrdersDao();
	            oD.doAdd(new Orders(email,0,Date.valueOf(dtf.format(now))));
	            
	            Orders o = oD.doRetrieveByKey(email).get(0);
	            ProductsDao pD = new ProductsDao();
	            Products prod = new Products(o.getCodeOrder(),0,treeToBuy.getName(),treeToBuy.getSpecies(),treeToBuy.getCountry(),treeToBuy.getCo2(),treeToBuy.getDescription(),1,treeToBuy.getPrice()); 
            	pD.doAdd(prod, o.getCodeOrder());
            	response.setStatus(200);
            	return;
				
			}else {
				if(email==null) {
					response.setStatus(201);
					return;
				}
				ShoppingCartDao scD = new ShoppingCartDao();
				ShoppingCart sc= scD.doRetrieveByKey(email);
				ArrayList<Tree> list= scD.doRetrieveTrees(sc.getcodeCart());
				int i=0;
				int j;
				//double sum=0;
            
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				OrdersDao oD = new OrdersDao();
				oD.doAdd(new Orders(email,0,Date.valueOf(dtf.format(now))));
            
				Orders o = oD.doRetrieveByKey(email).get(0);
				ProductsDao pD = new ProductsDao();
				for(i=0;i<list.size();i++){
					int count=1;  
					Tree currentTree=list.get(i); 
					scD.doRemoveTree(sc.getcodeCart(), currentTree.getCodeTree());
					for(j=i+1;j<list.size();j++){
						if(list.get(i).getName().equals(list.get(j).getName())){
							scD.doRemoveTree(sc.getcodeCart(), list.get(j).getCodeTree());
							list.remove(j);
							j--;
							count++;
						}
					}
					Products prod = new Products(o.getCodeOrder(),0,currentTree.getName(),currentTree.getSpecies(),currentTree.getCountry(),currentTree.getCo2(),currentTree.getDescription(),count,currentTree.getPrice()); 
					pD.doAdd(prod, o.getCodeOrder());
					//sum=sum+(count*list.get(i).getPrice());
				}
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
