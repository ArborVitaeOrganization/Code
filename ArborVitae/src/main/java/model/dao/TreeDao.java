package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ConPool;
import model.bean.Tree;
import model.interfaces.TreeModel;

public class TreeDao implements TreeModel {

	public TreeDao() {
	}

	public ArrayList<Tree> doRetrieveByInformations(String name, String species, String country, String co2) {
		PreparedStatement pr = null;
		ResultSet rs = null;

		try (Connection c = ConPool.getConnection()) {

			if (name != null) {
				pr = c.prepareCall("SELECT * FROM Tree WHERE Name=?");
				pr.setString(1, name);
			}
			if (species != null) {
				pr = c.prepareCall("SELECT * FROM Tree WHERE Species=?");
				pr.setString(1, species);
			}
			if (country != null) {
				pr = c.prepareCall("SELECT * FROM Tree WHERE Country=?");
				pr.setString(1, country);
			}
			if (co2 != null) {
				pr = c.prepareCall("SELECT * FROM Tree WHERE CO2=?");
				pr.setString(1, co2);
			}

			rs = pr.executeQuery();
			ArrayList<Tree> list = new ArrayList<Tree>();

			String n, s, ci, country1, description;
			double price;
			int codeTree;
			while (rs.next()) {

				n = rs.getString("Name");
				s = rs.getString("Species");
				country1 = rs.getString("Country");
				ci = rs.getString("CO2");
				description = rs.getString("Description");
				price = rs.getDouble("Price");
				codeTree = rs.getInt("codeTree");
				Tree tree = new Tree(n, s, country1, ci, description, price, codeTree);
				list.add(tree);
			}
			if (list.size() == 0)
				return null;
			else
				return list;

		} catch (SQLException e) {
			e.getErrorCode();
			e.getMessage();
			return null;
		}
	}

	public ArrayList<Integer> doRetrieveCode() {
		PreparedStatement pr = null;
		ResultSet rs = null;
		try (Connection c = ConPool.getConnection()) {
			pr = c.prepareStatement("SELECT CodeTree FROM Tree ORDER BY Name ASC");
			rs = pr.executeQuery();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (rs.next()) {
				list.add(rs.getInt("CodeTree"));
			}
			return list;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	public ArrayList<Tree> doRetrieveTree(int i) {
		PreparedStatement pr = null;
		ResultSet rs = null;
		try (Connection c = ConPool.getConnection()) {
			String str = "SELECT * FROM Tree ";
			// pr = c.prepareStatement("SELECT * FROM Tree ORDER BY ? ASC");
			if (i == 1) {
				str += "ORDER BY Name ASC";
			} else if (i == 2)
				str += "ORDER BY CO2 ASC";
			else
				str += "ORDER BY Price ASC";
			pr = c.prepareStatement(str);
			rs = pr.executeQuery();
			ArrayList<Tree> list = new ArrayList<Tree>();
			String name, species, country, co2, description;
			double prices;
			int codeTree;
			while (rs.next()) {
				name = rs.getString("Name");
				species = rs.getString("Species");
				country = rs.getString("Country");
				co2 = rs.getString("CO2");
				description = rs.getString("Description");
				prices = rs.getDouble("Price");
				codeTree = rs.getInt("codeTree");
				Tree t = new Tree(name, species, country, co2, description, prices, codeTree);
				list.add(t);
			}
			if (list.size() == 0)
				return null;
			else
				return list;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}

	public ArrayList<Tree> doRetrieveByPrice(double p1, double p2) {
		PreparedStatement pr = null;
		ResultSet rs = null;

		try (Connection c = ConPool.getConnection()) {
			pr = c.prepareStatement("SELECT * FROM Tree WHERE price BETWEEN ? AND ? ;");
			pr.setDouble(1, p1);
			pr.setDouble(2, p2);

			rs = pr.executeQuery();

			ArrayList<Tree> list = new ArrayList<Tree>();
			String name, species, country, co2, description;
			int codeTree;
			double price;

			while (rs.next()) {

				name = rs.getString("Name");
				species = rs.getString("Species");
				country = rs.getString("Country");
				co2 = rs.getString("CO2");
				description = rs.getString("Description");
				price = rs.getDouble("Price");
				codeTree = rs.getInt("codeTree");
				Tree t = new Tree(name, species, country, co2, description, price, codeTree);

				list.add(t);
			}

			if (list.size() == 0)
				return null;
			else
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

	public boolean doUpdate(String name, String des, double price) {
		PreparedStatement pr = null;
		try (Connection c = ConPool.getConnection()) {
			if (des == null)
				if (price <= 0)
					return false;
				else {
					pr = c.prepareStatement("UPDATE Tree SET Price=? WHERE Name=? ;");
					pr.setDouble(1, price);
					pr.setString(2, name);
				}
			else if (price <= 0) {
				pr = c.prepareStatement("UPDATE Tree SET Description=? WHERE Name=? ;");
				pr.setString(1, des);
				pr.setString(2, name);
			} else {
				pr = c.prepareStatement("UPDATE Tree SET Description=? , Price=? WHERE Name=? ;");
				pr.setString(1, des);
				pr.setDouble(2, price);
				pr.setString(3, name);
			}

			int x = pr.executeUpdate();

			if (x <= 0)
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

	public boolean doDelete(String nome) {
		PreparedStatement pr = null;
		try (Connection c = ConPool.getConnection()) {

			pr = c.prepareStatement("DELETE FROM Tree WHERE Name=? ;");
			pr.setString(1, nome);

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

	public boolean doAdd(String name, String species, String country, String co2, String description, double price) {
		PreparedStatement pr = null;

		try (Connection c = ConPool.getConnection()) {
			java.sql.Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Tree");
			while (rs.next()) {
				if (name.equals(rs.getString("name")))
					return false;
			}
			pr = c.prepareStatement(
					"INSERT INTO Tree (Name, Species, Country, CO2, Description, Price) VALUES(?,?,?,?,?,?)");

			pr.setString(1, name);
			pr.setString(2, species);
			pr.setString(3, country);
			pr.setString(4, co2);
			pr.setString(5, description);
			pr.setDouble(6, price);

			if (pr.executeUpdate() != 1)
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.getMessage();
			e.getErrorCode();
			return false;
		}
	}

}