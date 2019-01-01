package user;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.engine.spi.ActionQueue;


import model.AspNetUser;
import service.UserLoginSignLocal;

@ManagedBean
@SessionScoped
public class Identity {
	// Injection de dependence
	@EJB
	private UserLoginSignLocal basicOpsLocal;
	private Boolean loggedInAsAgent = false;
	private AspNetUser user = new AspNetUser();
	private boolean isLogged = false;

	public String logout() {
		isLogged = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/loginI?faces-redirect=true";
	}

	public String doLogin() {
		String navigateTo = "";
		AspNetUser userLoggedIn = basicOpsLocal.login(user.getEmail(), user.getPasswordHash());
		if (userLoggedIn != null) {
			isLogged = true;
			user = userLoggedIn;
			if (userLoggedIn.getDiscriminator().equals("Doctor")) {
				navigateTo = "welcomeDoc.jsf?faces-redirect=true";
			} else if  (userLoggedIn.getDiscriminator().equals("Patient")) {
				navigateTo = "welcomePat.jsf?faces-redirect=true";
			}
		} else {
			System.err.println("not");
		}
		return navigateTo;
	}

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

	public Boolean getLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(Boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
