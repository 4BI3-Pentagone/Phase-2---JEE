package BeanEmel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AspNetUser;


@ManagedBean
@ViewScoped
public class managedBeanEmel {
	@EJB
	PatBean pb ;
	List<AspNetUser> mypatient = new ArrayList<AspNetUser>();
	
			//pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");

	public List<AspNetUser> get()
	{return pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");
}
	@PostConstruct
	private void init() {
		mypatient=pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");
	}
	public List<AspNetUser> getMypatient() {
		return mypatient;
	}
	public void setMypatient(List<AspNetUser> mypatient) {
		this.mypatient = mypatient;
	}
	
}
