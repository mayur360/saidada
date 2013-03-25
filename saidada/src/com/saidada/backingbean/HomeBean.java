package com.saidada.backingbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "homeBean")
@RequestScoped
public class HomeBean {

	public String getHttpScheme() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getScheme();
	}

	public void idleListener() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Your session has expired",
						"Sorry, you have been idle for more than 20 minutes. Please refresh the page to continue"));

		// invalidate session
	}
}
