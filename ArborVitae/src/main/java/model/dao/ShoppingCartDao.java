
package model.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ConPool;
import model.bean.ShoppingCart;
import model.bean.Tree;
import model.interfaces.ShoppingCartModel;

public class ShoppingCartDao implements ShoppingCartModel{

 public ShoppingCartDao() {
 }
 
 public boolean doAdd(String email) {
  PreparedStatement pr=null;
  
  try (Connection c=ConPool.getConnection()){
   pr=c.prepareStatement("INSERT INTO SHOPPINGCART (email,numItems) VALUES(?,?);");
   pr.setString(1,email);
   pr.setInt(2,0);
   int x=pr.executeUpdate();
   if(x==0) return false;
   else return true;
   
   }catch(SQLException e){
    e.getMessage();
    return false;
   }finally {
   try {
    pr.close();
   }catch(SQLException e) {
    e.getMessage();
    e.getErrorCode();
   }
  }
 }

 public boolean doAddTree(int codeCart,int codeTree) {
  PreparedStatement pr=null,ps=null;
 
  try (Connection c=ConPool.getConnection()){
   pr=c.prepareStatement("INSERT INTO ISIN (codeCart,codeTree) Values(?,?) ;");
   pr.setInt(1, codeCart);
   pr.setInt(2, codeTree);
   int x=pr.executeUpdate();
   if(x==0) 
    return false;
   else {
    ps=c.prepareStatement("UPDATE SHOPPINGCART SET numItems=numItems+1 WHERE codeCart=?");
    ps.setInt(1, codeCart);
    ps.executeUpdate();
    return true;
   }
   }catch(SQLException e) {
    e.getMessage();
    e.getErrorCode();
    return false;
   }finally{
	   try {
		   pr.close();
		   ps.close();
	   }catch(SQLException e) {
		   e.getMessage();
		   e.getErrorCode();
	   }
   }
 }
 
 public boolean doRemoveTree(int codeCart,int codeTree) {
  PreparedStatement pr=null,ps=null;
  
  try(Connection c=ConPool.getConnection()){
   pr=c.prepareStatement("DELETE FROM ISIN WHERE codecart=? AND codeTree=? LIMIT 1;");
   pr.setInt(1, codeCart);
   pr.setInt(2, codeTree);
   int x=pr.executeUpdate();
   if(x==0) {
	   return false;
	}else {
	    ps=c.prepareStatement("UPDATE SHOPPINGCART SET numItems=numItems-1 WHERE codeCart=? ;");
	    ps.setInt(1, codeCart);
	    
	    int y=ps.executeUpdate();
	    if(y==0) return false;
	    else return true;
   }
  }catch(SQLException e) {
   System.out.println(e.getMessage());
   System.out.println(e.getErrorCode());
   return false;
  }
 }

public boolean doRemove(int codeCart) {
  PreparedStatement pr=null;
  
  try(Connection c=ConPool.getConnection()){
   pr=c.prepareStatement("DELETE FROM ISIN WHERE codeCart=? ;");
   pr.setInt(1, codeCart);
   
   int x=pr.executeUpdate();
   
   pr=c.prepareStatement("DELETE FROM ShoppingCart WHERE codeCart=? ;");
   pr.setInt(1, codeCart);
   x=pr.executeUpdate();
   
   if(x==0) {
    return false;
   }else return true;
   
  }catch(SQLException e) {
   e.getMessage();
   e.getErrorCode();
   return false;
  }
 }
 
 
 public ShoppingCart doRetrieveByKey(String email) {
  PreparedStatement pr=null;
  ResultSet rs=null;
  
  try(Connection c = ConPool.getConnection()){
   pr=c.prepareStatement("SELECT * FROM SHOPPINGCART WHERE email=?;");
   pr.setString(1, email);
   rs=pr.executeQuery();
   if(!rs.next()) return null;
   else {
    ShoppingCart s = new ShoppingCart(rs.getString("email"),rs.getInt("numItems"),rs.getInt("codeCart"));
    return s;
   }
  }catch(SQLException e) {
   e.getMessage();
   e.getErrorCode();
   return null;
  }finally {
   try {
    pr.close();
    rs.close();
   }catch(SQLException e) {
    e.getMessage();
    e.getErrorCode();
   }
  }
 }
 public ArrayList<Tree> doRetrieveTrees(int codeCart) {
  PreparedStatement pr=null;
  ResultSet rs=null;
  ArrayList<Tree> list=new ArrayList<Tree>();
  try(Connection c = ConPool.getConnection()){
   pr=c.prepareStatement("SELECT * FROM ISIN,Tree WHERE ISIN.codeTree=Tree.codeTree AND ISIN.codeCart =?;");
   pr.setInt(1, codeCart);
   rs=pr.executeQuery();
   while(rs.next()){
    Tree tree=new Tree(rs.getString("name"),rs.getString("species"),rs.getString("country"),rs.getString("co2"),rs.getString("description"),rs.getDouble("price"),rs.getInt("codeTree"));
    list.add(tree);
   }
   
   return list;
  }catch(SQLException e) {
   e.getMessage();
   e.getErrorCode();
   return null;
  }finally {
   try {
    pr.close();
    rs.close();
   }catch(SQLException e) {
    e.getMessage();
    e.getErrorCode();
   }
  }
 }
}