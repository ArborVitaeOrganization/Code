package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ConPool;
import model.bean.Orders;
import model.bean.Products;
import model.interfaces.ProductModel;

public class ProductsDao implements ProductModel {

	
	public ArrayList<Products> doRetrieveByKey(int codeOrder){
		PreparedStatement pr=null,ps = null;
		ResultSet rs = null, res=null;
		
		try(Connection con = ConPool.getConnection()){
			
			pr=con.prepareStatement("SELECT codeProduct FROM MADEBY WHERE codeOrder = ?;");
			pr.setInt(1, codeOrder);
			rs=pr.executeQuery();
			ArrayList<Products> list = new ArrayList<Products>();
			while(rs.next()) {
				ps=con.prepareStatement("SELECT * FROM PRODUCTS WHERE codeProduct=?;");
				ps.setInt(1, rs.getInt("codeProduct"));
				res=ps.executeQuery();
				if(res.next()) {
					Products prod = new Products(res.getInt("codeOrder"),res.getInt("codeProduct"),res.getString("name"),res.getString("species"),res.getString("country"),res.getString("co2"),res.getString("description"),res.getInt("quantity"),res.getDouble("price"));
					list.add(prod);
				}
			}
			return list;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			return null;
		}finally {
			try {
				pr.close();
				ps.close();
				rs.close();
				res.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
			}
		}
	}
	
	public boolean doAdd(Products prod,int codeOrder){
		PreparedStatement pr=null,ps=null,pc=null;
		ResultSet rs=null;
		try(Connection con = ConPool.getConnection()){
			
			pr=con.prepareStatement("INSERT INTO PRODUCTS (codeOrder,name,species,country,co2,description,price,quantity) VALUES(?,?,?,?,?,?,?,?);");
			pr.setInt(1, prod.getCodeOrder());
			pr.setString(2, prod.getName());
			pr.setString(3, prod.getSpecies());
			pr.setString(4, prod.getCountry());
			pr.setString(5, prod.getCo2());
			pr.setString(6, prod.getDescription());
			pr.setDouble(7, prod.getPrice());
			pr.setInt(8, prod.getQuantity());
			
			int x = pr.executeUpdate();
			if(x==0) return false;
			else {
				pc=con.prepareStatement("SELECT codeProduct FROM PRODUCTS WHERE codeOrder=? AND name=?;");
				pc.setInt(1, codeOrder);
				pc.setString(2, prod.getName());
				rs=pc.executeQuery();
				rs.next();
				ps=con.prepareStatement("INSERT INTO MADEBY (codeOrder,codeProduct) VALUES(?,?);");
				ps.setInt(1, codeOrder);
				ps.setInt(2, rs.getInt("codeProduct"));
				int y = ps.executeUpdate();
				if(y==0) return false;
				else return true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			return false;
		}finally {
			try {
				pr.close();
				ps.close();
				rs.close();
				pc.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
			}
		}
	}
}
