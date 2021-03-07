package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrderBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrderBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");

	}
	
	public OrdersBusinessService() {
		
		orders.add(new Order("000000","Product 1", (float)1.00, 10 ));
		orders.add(new Order("000001","Product 2", (float)10.00, 2 ));
		orders.add(new Order("000002","Product 3", (float)122.00, 1 ));
		orders.add(new Order("000003","Product 4", (float)11.00, 3 ));
		orders.add(new Order("000004","Product 5", (float)156.00, 1 ));
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
		
	}

}
