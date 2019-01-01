package Mayssa;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import service.UserServiceLocal;
import model.User;

@ManagedBean
@RequestScoped
public class Login {

    private String nom;
	private String password;
	@EJB
	private UserServiceLocal userService;
	private User user = new User();
	private Boolean isLogged = false;
	private static User stUser;
	private static User conUser;
	public static int i = 0;
	private List<User> listUsers;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUsers() {
		
			return listUsers;
		
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	public Login() {
		super();
	}
	
	
	 public void login() {
	        
	        FacesContext context = FacesContext.getCurrentInstance();

	        if(this.nom.equals("admin") && this.password.equals("admin")){
	            context.getExternalContext().getSessionMap().put("user", nom);
	            try {
					context.getExternalContext().redirect("Home.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        else  {
	            context.addMessage(null, new FacesMessage("Authentication Failed. Check nom or password."));

	        } 
	    }

	    public void logout() {
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	context.getExternalContext().invalidateSession();
	        try {
				context.getExternalContext().redirect("Login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    
		 public String getnom() {
				return nom;
			}

			public void setnom(String nom) {
				this.nom = nom;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getNom() {
				return nom;
			}

			public void setNom(String nom) {
				this.nom = nom;
			}

			public Boolean getIsLogged() {
				return isLogged;
			}

			public void setIsLogged(Boolean isLogged) {
				this.isLogged = isLogged;
			}

			public static User getStUser() {
				return stUser;
			}

			public static void setStUser(User stUser) {
				Login.stUser = stUser;
			}

			public static User getConUser() {
				return conUser;
			}

			public static void setConUser(User conUser) {
				Login.conUser = conUser;
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
						if (user.getRole().equals("Admin")) {
							navTo = "/PagesAdmin/index?faces-redirect=true";
							// redirect to profile user
						}
						if (!user.getRole().equals("Admin")) {
							navTo = "/Pages/index?faces-redirect=true";
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
			
}
