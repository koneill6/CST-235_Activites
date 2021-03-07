package controllers;

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

	@Inject
	OrderBusinessInterface s = new OrdersBusinessService();
	
	@EJB
	MyTimerService timer = new MyTimerService();
	
	public String onSubmit() {
		
		//prints message to console
		s.test();

		//Start a timer
		timer.setTimer(5000);
		
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
	
	
}
