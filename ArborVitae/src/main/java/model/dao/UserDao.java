package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ConPool;
import model.bean.User;
import model.interfaces.UserModel;

public class UserDao implements UserModel{
	
	public UserDao() {
	}
	
	public boolean doRetrieveByKey(String email,String password) {
		PreparedStatement pr=null;
		ResultSet rs=null;
		try (Connection con = ConPool.getConnection()) {
			pr=con.prepareStatement("SELECT * FROM USER WHERE email=? AND password=SHA1(?);");
			pr.setString(1, email);
			pr.setString(2, password);
			rs= pr.executeQuery();
			if(rs.next()) 
				return true;
			else return false;
		}catch(SQLException e) {
			e.getErrorCode();
			e.getMessage();
			return false;
		}finally {
			try {
				pr.close();
				rs.close();
				//Operazione per ritornare la connessione al Connection Pool
			}
			catch(SQLException e) {
				
			}
		}

	}
	
	public boolean doDelete(String user) {
		PreparedStatement p=null;
		
		try (Connection con = ConPool.getConnection()) {
			p=con.prepareStatement("DELETE FROM USER WHERE email=?;");
			p.setString(1, user);
			int r=p.executeUpdate();
			if(r==0)return false;
			else return true;
		}catch(SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return false;
		}finally {
			try {
				p.close();
				//Operazione per ritornare la connessione al Connection Pool
			}catch(SQLException e) {
				
			}
		}
	}
	
	public boolean doUpdate(User user,User.userRole u) {
		PreparedStatement p=null;
		if(user.getRole()==u)
			return false;
		try (Connection con = ConPool.getConnection()){
			p=con.prepareStatement("UPDATE USER SET role=? WHERE email=?;");
			if(u==User.userRole.Admin)
				p.setString(1, "Admin");
			else p.setString(1, "User");
			p.setString(2,user.getEmail());
			int r=p.executeUpdate();
			if(r==0)return false;
			else return true;
		}catch(SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return false;
		}finally {
			try {
				p.close();
			}catch(SQLException e) {
				
			}
		}
	}
	
	public User doLogin(String email, String password)
	{
		try (Connection con = ConPool.getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE Email=? AND Password=SHA1(?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			User p;
			if(rs.next()) {
				if(rs.getString(5).equals("User")) {
					p = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), User.userRole.User);
				}else {
					p = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), User.userRole.Admin);
				}
			return p;
			}
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean doSave(User u) throws SQLException
	{
		try(Connection con = ConPool.getConnection())
		{
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Email FROM User");
			while(rs.next())
			{
				if(u.getEmail().equals(rs.getString(1)))
					return false;
			}
			PreparedStatement ps = con.prepareStatement("INSERT INTO User (Email, Name, Surname, Country, Role, Password) VALUES (?, ?, ?, ?, ?, SHA1(?))");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getName());
			ps.setString(3, u.getSurname());
			ps.setString(4, u.getCountry());
			if(u.getRole().equals(User.userRole.User))
				ps.setString(5, "User");
			else
				ps.setString(5, "Admin");
			ps.setString(6, u.getPassword());
			if(ps.executeUpdate()==1)
				return true;
			return false;
		}catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<User> doRetriveRole(int i)
	{
		try(Connection con = ConPool.getConnection())
		{
			ArrayList<User> list = new ArrayList<User>();
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User");
			while(rs.next())
			{	
				if(i==1) {
					if(rs.getString(5).equals("Admin")) {
						String email, nome, cognome, paese;
						email = rs.getString(1);
						nome = rs.getString(2);
						cognome = rs.getString(3);
						paese = rs.getString(4);
						User u = new User(email, nome, cognome, paese, "", User.userRole.Admin);
						list.add(u);
					}
				}
				else if(i==2) {
					if(rs.getString(5).equals("User")) {
						String email, nome, cognome, paese;
						email = rs.getString(1);
						nome = rs.getString(2);
						cognome = rs.getString(3);
						paese = rs.getString(4);
						User u = new User(email, nome, cognome, paese, "", User.userRole.User);
						list.add(u);
					}
				}
			}
			return list;
		}catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
}
