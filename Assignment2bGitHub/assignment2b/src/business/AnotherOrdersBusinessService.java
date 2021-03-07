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
public class AnotherOrdersBusinessService implements OrderBusinessInterface {

	List<Order> orders = new ArrayList<Order>();
	
	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");

	}

	public AnotherOrdersBusinessService() {
		
		orders.add(new Order("000005","Product A", (float)1.00, 10 ));
		orders.add(new Order("000006","Product B", (float)10.00, 2 ));
		orders.add(new Order("000007","Product C", (float)122.00, 1 ));
		orders.add(new Order("000008","Product D", (float)11.00, 3 ));
		orders.add(new Order("000009","Product E", (float)156.00, 1 ));
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
