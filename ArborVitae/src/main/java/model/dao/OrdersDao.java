package model.dao;

import model.interfaces.OrdersModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.bean.ConPool;
import model.bean.Orders;
import model.bean.Products;
import model.bean.ShoppingCart;
import model.bean.Tree;

public class OrdersDao implements OrdersModel {

	public ArrayList<Orders> doRetrieveByKey(String email)/* , Date data1, Date data2) */ {
		PreparedStatement pr = null;
		ResultSet rs = null;

		try (Connection c = ConPool.getConnection()) {
			pr = c.prepareStatement("SELECT * FROM ORDERS WHERE email = ? ORDER BY codeOrder DESC;");
			if (email == null)
				pr.setString(1, "%");
			else
				pr.setString(1, email);
			/*
			 * if(data1==null) pr.setDate(2, "%"); else pr.setDate(2, data1);
			 * if(data2==null) pr.setDate(3, "%"); else pr.setDate(3, data2);
			 */
			rs = pr.executeQuery();
			ArrayList<Orders> or = new ArrayList<Orders>();

			while (rs.next()) {
				Orders o = new Orders(rs.getString("email"), rs.getInt("codeOrder"), rs.getDate("data"));
				or.add(o);
			}
			return or;

		} catch (SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return null;
		} finally {
			try {
				pr.close();
				rs.close();
			} catch (SQLException e) {
				e.getMessage();
				e.getErrorCode();
			}
		}
	}

	public ArrayList<Products> doRetrieveKey(String email, String data1, String data2){
	      PreparedStatement pr=null;
	      PreparedStatement pr2 = null;
	      ResultSet rs=null;
	      ResultSet rs2 = null;
	      
	      try(Connection c=ConPool.getConnection()){
	        
	        if(email==null && data1==null && data2==null)
	        	pr = c.prepareStatement("SELECT * FROM Orders");
	        else if(email==null && data1==null) {
	        	pr = c.prepareStatement("SELECT * FROM Orders WHERE Data<=?");
	        	java.util.Date d2 = new java.util.Date();
		            try {
						d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          Date sqlDate = new Date(d2.getTime());
		          pr.setDate(1, sqlDate);
		        }
	        else if(email==null && data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Data>=?");
	          java.util.Date d2 = new java.util.Date();
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(1, sqlDate);
	        }
	        else if(data1==null && data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=?");
	          pr.setString(1, email);
	        }
	        else if(email==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Data>=? AND Data<= ?");
	          java.util.Date d1 = new java.util.Date();
	          try {
	            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
	          }catch(ParseException e) {
	            e.printStackTrace();
	          }
	          Date sqlDate1 = new Date(d1.getTime());
	          pr.setDate(1, sqlDate1);
	          java.util.Date d2 = new java.util.Date();
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        else if(data1==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=? AND Data<= ?");
	          pr.setString(1, email);
	          java.util.Date d2 = new java.util.Date();
	          
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        else if(data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=? AND Data>= ?");
	          pr.setString(1, email);
	          java.util.Date d2 = new java.util.Date();
	          try {
	            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
	          }catch(ParseException e) {
	            e.printStackTrace();
	          }
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        ArrayList<Products> prolist = new ArrayList<Products>();
	        try {
	        rs=pr.executeQuery();
	        ArrayList<Orders> or = new ArrayList<Orders>();
	        while(rs.next())
	        {
	          pr2 = c.prepareStatement("SELECT * FROM Products WHERE CodeOrder = ?");
	          pr2.setString(1, rs.getString("CodeOrder"));
	          rs2=pr2.executeQuery();
	          while(rs2.next())
	          {
	            int co = rs2.getInt("CodeOrder");
	            int cp = rs2.getInt("CodeProduct");
	            String n = rs2.getString("Name");
	            String s = rs2.getString("Species");
	            String cou = rs2.getString("Country");
	            String co2 = rs2.getString("CO2");
	            String d = rs2.getString("Description");
	            double p = rs2.getDouble("Price");
	            int q = rs2.getInt("Quantity");
	            Products prod = new Products(co, cp, n, s, cou, co2, d, q, p);
	            prolist.add(prod);
	          }
	          
	        }
	        return prolist;
	        }catch(SQLException e) {}
	      }catch(SQLException e1) {}
		return null;
	      
	}
	
	public ArrayList<Orders> doRetrieveDate(String email, String data1, String data2)
	{
		PreparedStatement pr=null;
	      PreparedStatement pr2 = null;
	      ResultSet rs=null;
	      ResultSet rs2 = null;
	      
	      try(Connection c=ConPool.getConnection()){
	        
	        if(email==null && data1==null && data2==null)
	        	pr = c.prepareStatement("SELECT * FROM Orders");
	        else if(email==null && data1==null) {
	        	pr = c.prepareStatement("SELECT * FROM Orders WHERE Data<=?");
	        	java.util.Date d2 = new java.util.Date();
		            try {
						d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		          Date sqlDate = new Date(d2.getTime());
		          pr.setDate(1, sqlDate);
		        }
	        else if(email==null && data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Data>=?");
	          java.util.Date d2 = new java.util.Date();
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(1, sqlDate);
	        }
	        else if(data1==null && data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=?");
	          pr.setString(1, email);
	        }
	        else if(email==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Data>=? AND Data<= ?");
	          java.util.Date d1 = new java.util.Date();
	          try {
	            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
	          }catch(ParseException e) {
	            e.printStackTrace();
	          }
	          Date sqlDate1 = new Date(d1.getTime());
	          pr.setDate(1, sqlDate1);
	          java.util.Date d2 = new java.util.Date();
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        else if(data1==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=? AND Data<= ?");
	          pr.setString(1, email);
	          java.util.Date d2 = new java.util.Date();
	          
	            try {
					d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        else if(data2==null) {
	          pr = c.prepareStatement("SELECT * FROM Orders WHERE Email=? AND Data>= ?");
	          pr.setString(1, email);
	          java.util.Date d2 = new java.util.Date();
	          try {
	            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
	          }catch(ParseException e) {
	            e.printStackTrace();
	          }
	          Date sqlDate = new Date(d2.getTime());
	          pr.setDate(2, sqlDate);
	        }
	        rs=pr.executeQuery();
	        ArrayList<Orders> or = new ArrayList<Orders>();
	        while(rs.next())
	        {
	        	String e = rs.getString("Email");
	        	int co = rs.getInt("CodeOrder");
	        	java.util.Date d = rs.getDate("Data");
	        	Orders o = new Orders(e, co, (Date) d);
	        	or.add(o);
	        }
	        return or;
	      }catch(SQLException e2) {return null;}
	}
	      
	public ArrayList<Orders> doRetrieveAll() {
		PreparedStatement pr = null;
		ResultSet rs = null;
		try (Connection c = ConPool.getConnection()) {
			pr = c.prepareStatement("SELECT * FROM ORDERS");
			rs = pr.executeQuery();
			ArrayList<Orders> list = new ArrayList<Orders>();
			while (rs.next()) {
				Orders or = new Orders(rs.getString("email"), rs.getInt("codeOrder"), rs.getDate("data"));
				list.add(or);
			}

			return list;

		} catch (SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return null;
		} finally {
			try {
				pr.close();
				rs.close();
			} catch (SQLException e) {
				e.getMessage();
				e.getErrorCode();
			}
		}
	}

	public boolean doAdd(Orders orders) {
		PreparedStatement pr = null;
		try (Connection c = ConPool.getConnection()) {
			pr = c.prepareStatement("INSERT INTO ORDERS (email,data) VALUES (?,?);");
			pr.setString(1, orders.getEmail());
			pr.setDate(2, orders.getDate());
			int x = pr.executeUpdate();
			if (x == 0)
				return false;
			else
				return true;

		} catch (SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return false;
		} finally {
			try {
				pr.close();
			} catch (SQLException e) {
				e.getMessage();
				e.getErrorCode();
			}
		}
	}
}
