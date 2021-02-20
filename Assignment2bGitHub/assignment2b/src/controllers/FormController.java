package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean

public class FormController {

	public String onSubmit() {
		
		// get the user values from the input form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		//put user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//show next page
		return "Response.xhtml";
	}
	
	public String onFlash(User user) {

		//put user object into the POST request
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		
		//redirects from login to response page
		return "Response2.xhtml?faces-redirect=true";
	}
}
