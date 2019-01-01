package user;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AspNetUser;
import service.UserLoginSignLocal;




@ManagedBean
@ViewScoped
public class UserManagementBean {
	private AspNetUser us;
	@EJB
	private UserLoginSignLocal  basicOpsLocal;

	public String doAddStudent() {
		//us.setDiscriminator("Doctor");
		basicOpsLocal.addUser(us);
		return "loginI?faces-redirect=true";
	}

	@PostConstruct
	private void init() {
		us= new AspNetUser();
	}

	public AspNetUser getUs() {
		return us;
	}

	public void setUs(AspNetUser us) {
		this.us = us;
	}

	public UserLoginSignLocal getBasicOpsLocal() {
		return basicOpsLocal;
	}

	public void setBasicOpsLocal(UserLoginSignLocal basicOpsLocal) {
		this.basicOpsLocal = basicOpsLocal;
	}

	
	
}
