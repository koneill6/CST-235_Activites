package beans;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
public class Order {
	String ordernumber = "";
	String productname = "";
	float price = 0;
	int quantity = 0;
	
	
	public Order() {
		super();
	}


	public Order(String ordernumber, String productname, float price, int quantity) {
		super();
		this.ordernumber = ordernumber;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
