package business;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;
import beans.Orders;

@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService {

	
	@Inject
	OrderBusinessInterface obi;
	
	//get records and display in JSON
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() {
		return obi.getOrders();
	}
	
	//get one record by ID # and display in JSON
	@GET
	@Path("/getjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOneOrderAsJson(@PathParam("id") int id ) throws SQLException {
		return obi.getOne(id);
	}
	
	//get one record by name and display in JSON
	@GET
	@Path("/getjsonbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOneOrderAsJsonName(@PathParam("name") String name ) throws SQLException {
		return obi.searchFor(name);
	}
	
	//get records and display in XML
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXml() {
		List<Order> o = obi.getOrders();
		
		return o.toArray(new Order[o.size()]);
	}
	
}
