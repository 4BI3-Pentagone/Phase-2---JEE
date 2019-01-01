package Mayssa;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserServiceLocal;
import model.User;
import org.primefaces.PrimeFaces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@ApplicationScoped

public class UserBean implements Serializable {
	private int idUser;
	private String nom;
	private String prenom;
	private String role;
	private String password;
	private String email;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private List<User> users;
    
    private List<User> filteredUser;
     
    private User selectedUser;
    
    
	@EJB
	private UserServiceLocal userService;
	private boolean formDisplay = false;
	private List<User> list = new ArrayList<User>();


	private User user = new User();
	private Boolean isLogged = false;
	
	private static User stUser;
	private static User conUser;
	public static int i = 0;
	
	
	
	public List<User> displayCenter(){
		return list = userService.findAll();
	}

	
	
	public boolean isFormDisplay() {
		return formDisplay;
	}




	public void setFormDisplay(boolean formDisplay) {
		this.formDisplay = formDisplay;
	}




	public List<User> getList() {
		return list;
	}




	public void setList(List<User> list) {
		this.list = list;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public UserBean() {
		super();
	}

	public String Save(){
		userService.AddUser(user);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("effectué avec succés!!"));
		return "/faces/users?faces-redirect=true";
	}
	
	public void deleteUser() {
        userService.DeleteUser(getSelectedUser());
        selectedUser = null;
    }

	
	
	
	

	public String doLogin() {
		 
		String navTo = "";
		User found = userService.authenticate(user.getNom(), user.getPassword());
		if (i < 3) {

			if (found != null) {
				setConUser(found);
				user = found;
				
				setIsLogged(true);
				
				// redirect to admin
				if (user.getRole().equals("User")) {
					navTo = "/faces/user/a/1/accueil?faces-redirect=true";
					// redirect to profile user
				}
				if (!user.getRole().equals("User")) {
					navTo = "/faces/admin/Home?faces-redirect=true";
				}

			} else {
				i++;
				FacesContext.getCurrentInstance().addMessage("login_form:login_submit",
						new FacesMessage("Wrong Username or Password"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("login_form:login_submit",
					new FacesMessage("3 times wrong informations, access blocked for security reasons"));
		}

		return navTo;
	}
	
	 public String logout() {
	      HttpSession session = Util.getSession();
	      session.invalidate();
	      return "/faces/Login.xhtml";
	   }
	
	public void reset() {
        PrimeFaces.current().resetInputs("form1:panel");
    }
	
	
	
	public static User getConUser() {
		return conUser;
	}

	public static void setConUser(User conUser) {
		UserBean.conUser = conUser;
	}
	public  User getConUser1() {
		return conUser;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<User> getFilteredUser() {
		return filteredUser;
	}



	public void setFilteredUser(List<User> filteredUser) {
		this.filteredUser = filteredUser;
	}



	public User getSelectedUser() {
		return selectedUser;
	}



	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}




	
}
