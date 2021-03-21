package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("000000","Product 1", (float)1.00, 10 ));
		orders.add(new Order("000001","Product 2", (float)10.00, 2 ));
		orders.add(new Order("000002","Product 3", (float)122.00, 1 ));
		orders.add(new Order("000003","Product 4", (float)11.00, 3 ));
		orders.add(new Order("000004","Product 5", (float)156.00, 1 ));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
