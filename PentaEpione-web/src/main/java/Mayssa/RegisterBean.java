package Mayssa;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import service.UserServiceLocal;
import model.User;


@ManagedBean
@RequestScoped

public class RegisterBean {

	@EJB
	private UserServiceLocal userServiceLocal;

	@EJB
	private UserServiceLocal userService;

	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	private User user= new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RegisterBean() {
	}

	@PostConstruct
	public void init() {
		
	}

	public String doSignUp() {
		String navigateTo = null;
		userService.saveOrUpdate(user);
		//userBean.setUser(user);
		navigateTo = userBean.doLogin();
		return navigateTo;
	}


	public void validateLoginUnicity(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String emailToValidate = (String) value;
		if (emailToValidate == null || emailToValidate.trim().isEmpty()) {
			return;
		}
		boolean loginInUse = userServiceLocal.loginExists(emailToValidate);
		if (loginInUse) {
			FacesContext.getCurrentInstance().addMessage("master_register:msg_login",
					new FacesMessage("login already in use!"));
			throw new ValidatorException(new FacesMessage(
					"login already in use!"));
			
		}
	}


}
