package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Order;


public class DatabaseService {

	//connect DB
			String dbURL = "jdbc:mysql://localhost:3306/activity1";
			String user = "root";
			String password = "root";
				
			Connection c = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int rowsAffected = 0;
			
		//four crud operations
	
	public int deleteOne(int id) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("delete from activity1.orders where ORDER_ID = ?");
		pstmt.setInt(1, id);
		
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows deleted: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;
	}
	
	public int insertOne(Order u) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("insert into activity1.orders values(null, ?, ?, ?, ? )");
		pstmt.setString(1, u.getOrdernumber());
		pstmt.setString(2, u.getProductname());
		pstmt.setFloat(3, u.getPrice());
		pstmt.setInt(4, u.getQuantity());
		
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows Affected: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;	
	}
	
	public ArrayList<Order> readAll() throws SQLException{
		ArrayList<Order> everyone = new ArrayList<Order>();
		
		//db work

		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		stmt = c.createStatement();
		
		//execute the statement
		rs = stmt.executeQuery("Select * from activity1.orders");
		
		//process the rows in the result set
		while(rs.next()) {
			System.out.println("Order ID: "+rs.getInt("ORDER_ID")+" Order Nubmer: "+rs.getString("ORDER_NUMBER")+" Product Name: "+rs.getString("PRODUCT_NAME")+" Price: "+rs.getFloat("PRICE")+
					" Quantity: "+rs.getInt("QUANTITY"));
		}
		
		//close connection
		rs.close();
		stmt.close();
		c.close();
		
		return everyone;
	}
	
	public int updateOne(int id, Order u) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("update activity1.orders set ORDER_NUMBER=?, PRODUCT_NAME=?, PRICE=?, QUANTITY=? where USER_ID=?");
		pstmt.setString(1, u.getOrdernumber());
		pstmt.setString(2, u.getProductname());
		pstmt.setFloat(3, u.getPrice());
		pstmt.setInt(4, u.getQuantity());
		pstmt.setInt(5, id);
				
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows updated: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;
		
	}

	public Order readOne(int id) throws SQLException {

		Order o = null;
		//db work
		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("Select * from activity1.orders where ORDER_ID=?");
		pstmt.setInt(1, id);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			o = new Order(rs.getString("ORDER_NUMBER"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY"));
			
		}
				
		//close connection
		rs.close();
		pstmt.close();
		c.close();
		return o;
	}

	public List<Order> searchFor(String name) throws SQLException {
		List<Order> lo = new ArrayList<Order>();
		//db work
		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("Select * from activity1.orders where PRODUCT_NAME like ?");
		pstmt.setString(1, "%"+name+"%");
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Order o = new Order(rs.getString("ORDER_NUMBER"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY"));
			lo.add(o);
		}
				
		//close connection
		rs.close();
		pstmt.close();
		c.close();
		return lo;
	}
}
