package business;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrderBusinessInterface {

	
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
	public Order getOne(int id) throws SQLException;
	public List<Order> searchFor(String name) throws SQLException;
	
}
