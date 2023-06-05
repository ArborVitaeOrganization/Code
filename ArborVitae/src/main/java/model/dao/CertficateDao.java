package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Certificate;
import model.bean.ConPool;
import model.interfaces.CertificateModel;

public class CertficateDao implements CertificateModel{

	public boolean doAdd(Certificate cert) {
		PreparedStatement pr=null;
		
		try(Connection c=ConPool.getConnection()){
			pr=c.prepareStatement("INSERT INTO CERTIFICATE (codeCertificate,name,description,date) VALUES(?,?,?,?);");
			pr.setInt(1, cert.getCodeCertificate());
			pr.setString(2, cert.getName());
			pr.setString(3, cert.getDescription());
			pr.setDate(4, cert.getDate());
			
			int x=pr.executeUpdate();
			
			if(x==0) return false;
			else return true;
			
		}catch(SQLException e) {
			e.getMessage();
			e.getErrorCode();
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
	
	public Certificate doRetrieveByKey(int codeCertificate) {
		PreparedStatement pr=null;
		ResultSet rs=null;
		
		try(Connection c=ConPool.getConnection()){
			pr=c.prepareStatement("SELECT * FROM CERTIFICATE WHERE codeCertificate=?;");
			pr.setInt(1, codeCertificate);
			
			rs=pr.executeQuery();
			if(!rs.next()) return null;
			else {
				int code=rs.getInt("codeCertificate");
				String name=rs.getString("name");
				String description=rs.getString("description");
				Date date=rs.getDate("date");
				Certificate cert=new Certificate(code,name,description,date);
				return cert;
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
	
	public ArrayList<Certificate> doRetrieveByDate(Date date){
		PreparedStatement pr=null;
		ResultSet rs=null;
		ArrayList<Certificate> list=new ArrayList<Certificate>();
		try(Connection c= ConPool.getConnection()){
			pr=c.prepareStatement("SELECT * FROM CERTIFICATE WHERE date=?;");
			pr.setDate(1, date);
			rs=pr.executeQuery();
			
			while(rs.next()) {
				int code=rs.getInt("codeCertificate");
				String name=rs.getString("name");
				String description=rs.getString("description");
				Date d=rs.getDate("date");
				Certificate cert=new Certificate(code,name,description,d);
				list.add(cert);
			}
			return list;
			
		}catch(SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return list;
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
	
	
	public boolean doRemove(int codeCertificate) {
		PreparedStatement pr=null;
		
		try(Connection c=ConPool.getConnection()){
			pr=c.prepareStatement("DELETE FROM CERTIFICATE WHERE codeCertificate=?;");
			pr.setInt(1, codeCertificate);
			
			int x=pr.executeUpdate();
			
			if(x==0) return false;
			else return true;
			
		}catch(SQLException e) {
			e.getMessage();
			e.getErrorCode();
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
}
