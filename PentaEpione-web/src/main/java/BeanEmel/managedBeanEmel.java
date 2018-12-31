package BeanEmel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;

import com.itextpdf.text.DocumentException;

import model.Adresse;
import model.AspNetUser;
import model.Extract;
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
	Specialityy spe = new Specialityy();
	List<Specialityy> spelist = new ArrayList<Specialityy>();
	List<Adresse> citlist = new ArrayList<Adresse>();
	static List<Extract> extlist = new ArrayList<Extract>();
	Adresse adr = new Adresse();
	Extract ext = new Extract();
	@PostConstruct
	private void init() throws IOException, ParseException, JSONException {
	
		mypatient = extract.All();
		spelist = extract.ExtractSpeciality();
		// extract.getFrenshCities();
		citlist = extract.getFrenshCities();
		System.out.println("init" + adr);
		System.out.println("init" + spe);
	}
//	selecteddoct

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

	public Specialityy getSpe() {
		return spe;
	}

	public void setSpe(Specialityy spe) {
		this.spe = spe;
	}

	public List<Specialityy> getSpelist() {
		return spelist;
	}

	public List<Extract> getExtlist() {
		return extlist;
	}

	public void setExtlist(List<Extract> extlist) {
		this.extlist = extlist;
	}

	public Extract getExt() {
		return ext;
	}

	public void setExt(Extract ext) {
		this.ext = ext;
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

	public List<Adresse> getCitlist() {
		return citlist;
	}

	public void setCitlist(List<Adresse> citlist) {
		this.citlist = citlist;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	public void doAdd() throws IOException {
		System.out.println(extract.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa", "email@e.com"));
		// return extract.AddDoctor("meunier", "cecile", "medecin-generaliste",
		// "rouen", "pa","email@e.com");
	}

	public String dofind() throws IOException {
		System.out.println("a" + adr.getCity().toString());
		System.out.println("s" + spe.getName().toString());
		String s = spe.getName().toString().substring(spe.getName().indexOf("=") + 1, spe.getName().indexOf("]"));
		String a = adr.getCity().toString().substring(adr.getCity().indexOf("=") + 1, adr.getCity().indexOf("]"));
		//extract.SearchBySpecialityandPlace(s, a.toLowerCase());
		extlist.clear();
		System.out.println(extlist=extract.SearchBySpecialityandPlace(s,a.toLowerCase()));
	return"DoctorsListResult?faces-redirect=true";
	}

	public void doPrint() throws IOException, DocumentException {
		extract.getPDF();
	}

	public void doSpe() throws IOException {
		System.out.println(extract.ExtractSpeciality());
	}

	public void doCit() throws IOException, ParseException, JSONException {
		System.out.println(extract.getFrenshCities());
	}
}
