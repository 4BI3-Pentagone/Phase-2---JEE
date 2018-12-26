package BeanEmel;

import java.io.IOException;
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
	//@EJB
	//PatBean pb 

	@EJB
	ExtractionReso extract;
	List<AspNetUser> mypatient = new ArrayList<AspNetUser>();
	
			//pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");

	public List<AspNetUser> get()
	{return extract.All();
}
	@PostConstruct
	private void init()  {
	mypatient=extract.All();
	//	extract.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa","email@e.com");
	}
	public List<AspNetUser> getMypatient() {
		return mypatient;
	}
	public void setMypatient(List<AspNetUser> mypatient)  {
		this.mypatient = mypatient;
	}
	public void doAdd() throws IOException
	{		  System.out.println( extract.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa","email@e.com"));
		//return extract.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa","email@e.com");
}
	
}
