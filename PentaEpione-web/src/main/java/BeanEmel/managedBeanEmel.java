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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

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
	Specialityy spe = new Specialityy();
	List<Specialityy> spelist = new ArrayList<Specialityy>();
	List<Adresse> citlist = new ArrayList<Adresse>();
	static List<Extract> extlist = new ArrayList<Extract>();
	Adresse adr = new Adresse();
	Extract ext = new Extract();
	static Extract profile = new Extract();
	static MapModel pos = new DefaultMapModel();
	Extract register;
	AspNetUser connect;
	String blassa;
	String special;
	String firstname;
	String lastname;
	String pass;
	String email;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBlassa() {
		return blassa;
	}

	public void setBlassa(String blassa) {
		this.blassa = blassa;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Extract getRegister() {
		return register;
	}

	public void setRegister(Extract register) {
		this.register = register;
	}

	@PostConstruct
	private void init() throws IOException, ParseException, JSONException {

		// mypatient = extract.All();
		spelist = extract.ExtractSpeciality();
		// extract.getFrenshCities();
		citlist = extract.getFrenshCities();
		// System.out.println("init" + adr);
		// System.out.println("init" + spe);
		// pos = new DefaultMapModel();
		// System.out.println("prooooooooo"+extract.profile("www.doctolib.fr/osteopathe/saint-laurent-du-var/remi-picart"));
		// LatLng coord1 = new LatLng(36.748807, 10.305867);
		// extract.profile(ext.getProfile());
		// pos.addOverlay(new Marker(coord1, "Konyaalti"));
		register = new Extract();
		connect = new AspNetUser();
	}
	// selecteddoct

	public ExtractionReso getExtract() {
		return extract;
	}

	public AspNetUser getConnect() {
		return connect;
	}

	public void setConnect(AspNetUser connect) {
		this.connect = connect;
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

	public Extract getProfile() {
		return profile;
	}

	public void setProfile(Extract profile) {
		this.profile = profile;
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

	public String doAdd() throws IOException {
		connect = extract.AddDoctor(register.getLastname(), register.getFirstname(), register.getSpeciality_s(),
				"rouen", register.getPassword(), "email");
		// return extract.AddDoctor("meunier", "cecile", "medecin-generaliste",
		// "rouen", "pa","email@e.com");
		System.out.println("use"+connect);
		 return "../login?faces-redirect=true";
	}

	public String dofind() throws IOException {
		System.out.println("a" + adr.getCity().toString());
		System.out.println("s" + spe.getName().toString());
		String s = spe.getName().toString().substring(spe.getName().indexOf("=") + 1, spe.getName().indexOf("]"));
		String a = adr.getCity().toString().substring(adr.getCity().indexOf("=") + 1, adr.getCity().indexOf("]"));
		// extract.SearchBySpecialityandPlace(s, a.toLowerCase());
		extlist.clear();
		System.out.println(extlist = extract.SearchBySpecialityandPlace(s, a.toLowerCase()));
		return "DoctorsListResult?faces-redirect=true";
	}

	public String Profil() throws IOException {
		profile = extract.profile(ext.getProfile());
		System.out.println("profilede+" + profile.getAdresse());
		// final LatLng coord1 = new
		// LatLng(Double.parseDouble(profile.getLat()),
		// Double.parseDouble(profile.getLng()));
		// extract.profile(ext.getProfile());
		// System.out.println("lat "+Double.parseDouble(profile.getLat()));
		// System.out.println("lng "+Double.parseDouble(profile.getLng()));

		// pos.addOverlay(new Marker(coord1, "a"));
		pos = new DefaultMapModel();
		LatLng coord1 = new LatLng(Double.parseDouble(profile.getLat()), Double.parseDouble(profile.getLng()));
		pos.addOverlay(new Marker(coord1, "Dr." + profile.getLastname() + " cabinet"));
		return "Profil?faces-redirect=true";
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

	public MapModel getPos() {
		return pos;
	}

	public void setPos(MapModel pos) {
		this.pos = pos;
	}

}
