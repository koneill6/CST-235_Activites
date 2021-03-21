package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.AnotherOrdersBusinessService;
import business.MyTimerService;
import business.OrderBusinessInterface;
import business.OrdersBusinessService;

@ManagedBean
@ViewScoped
public class FormController {
	
	String dbURL = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String password = "root";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Inject
	OrderBusinessInterface s = new OrdersBusinessService();
	
	//@EJB
	//MyTimerService timer = new MyTimerService();
	
	public String onSubmit() throws Exception {
		
		
		
		getAllOrders();
		insertOrder();
		getAllOrders();
		//prints message to console
		//s.test();

		//Start a timer
		//timer.setTimer(5000);
		
		// get the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		

		//put user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//show next page
		return "Response.xhtml";
	}
	
	public String onFlash(User user) {

		//prints message to console
		//s.test();
				
		//put user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		
		
		
		//redirects from login to response page
		return "Response2.xhtml?faces-redirect=true";
	}
	
	public OrderBusinessInterface getService() {
		
		
		return s;
	}
	
	private void getAllOrders() throws ClassNotFoundException, SQLException {

		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Seccess!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failure!");
		}
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM testapp.ORDERS");
		while(rs.next()) {
			System.out.println("User ID: "+rs.getInt("ID")+" Product Name: "+rs.getString("PRODUCT_NAME")+" PRICE: "+rs.getFloat("PRICE"));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
	
	private void insertOrder() throws Exception {
		
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(dbURL, user, password);
		
		String s = "INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455', 'This was inserted new', 25.00, 100)";
		int i;
		
		stmt = conn.createStatement();
		i = stmt.executeUpdate(s);
		
		System.out.println("Rows updated: "+i);
		
		rs.close();
		stmt.close();
		conn.close();
		
		
	}
	
	public String goHome() {
		return "testform.xhtml?faces-redirect=true";
	}
	
}
