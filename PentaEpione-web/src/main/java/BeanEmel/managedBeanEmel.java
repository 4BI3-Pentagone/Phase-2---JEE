package BeanEmel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;

import com.itextpdf.text.DocumentException;

import model.AspNetUser;
import model.Specialityy;

@ManagedBean
@ViewScoped
public class managedBeanEmel {
	// @EJB
	// PatBean pb

	@EJB
	ExtractionReso extract;
	List<AspNetUser> mypatient = new ArrayList<AspNetUser>();
	String option;
	// pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");
	Specialityy spe;
	List<Specialityy> spelist = new ArrayList<Specialityy>();

	public ExtractionReso getExtract() {
		return extract;
	}

	public void setExtract(ExtractionReso extract) {
		this.extract = extract;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public List<AspNetUser> get() {
		return extract.All();
	}

	@PostConstruct
	private void init() throws IOException, ParseException, JSONException {
		mypatient = extract.All();
		spelist=extract.ExtractSpeciality();
		extract.getFrenshCities();
	}
	

	public Specialityy getSpe() {
		return spe;
	}

	public void setSpe(Specialityy spe) {
		this.spe = spe;
	}

	public List<Specialityy> getSpelist() {
		return spelist;
	}

	public void setSpelist(List<Specialityy> spelist) {
		this.spelist = spelist;
	}

	public List<AspNetUser> getMypatient() {
		return mypatient;
	}

	public void setMypatient(List<AspNetUser> mypatient) {
		this.mypatient = mypatient;
	}

	public void doAdd() throws IOException {
		System.out.println(extract.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa", "email@e.com"));
		// return extract.AddDoctor("meunier", "cecile", "medecin-generaliste",
		// "rouen", "pa","email@e.com");
	}

	public void dofind() throws IOException {
		System.out.println(extract.SearchBySpecialityandPlace("medecin-generaliste", "aix-en-provence"));

	}

	public void doPrint() throws IOException, DocumentException {
		extract.getPDF();
	}

	public void doSpe() throws IOException {
		System.out.println(extract.ExtractSpeciality());
	}

}
