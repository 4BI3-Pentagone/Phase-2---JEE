package BeanEmel;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.itextpdf.text.DocumentException;

import model.Adresse;
import model.AspNetUser;
import model.Extract;
import model.Specialityy;

@Stateless
@LocalBean
public class ExtractionReso implements ExtractionRemote {

	@PersistenceContext(unitName = "PentaEpione-ejb")
	EntityManager em;

	public ExtractionReso() {
		// super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override public ArrayList<Extract> SearchBySpeciality(String spec, int
	 * pagenumber) throws IOException { //
	 * https://www.doctolib.fr/medecin-generaliste/france Document doc;
	 * 
	 * Elements nom; Elements adresse; Elements specialite; String photo; String
	 * profil; int nb = 0; ArrayList<Extract> list = new ArrayList<>(); String
	 * url = "https://www.doctolib.fr/" + spec + "?page=" + pagenumber; doc =
	 * Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get(); Elements
	 * tableRows = doc.getElementsByClass("dl-search-result-presentation");
	 * 
	 * for (Element row : tableRows) { nb++; Extract ex = new Extract();
	 * System.out.println(nb); nom =
	 * row.getElementsByClass("dl-search-result-name").addClass(
	 * "js-search-result-path"); adresse =
	 * row.getElementsByClass("dl-text").addClass("dl-text-body"); specialite =
	 * row.getElementsByClass("dl-search-result-subtitle"); photo =
	 * row.getElementsByTag("img").attr("src"); profil =
	 * row.getElementsByTag("a").attr("href"); if (!nom.isEmpty() &&
	 * !specialite.isEmpty()) {
	 * 
	 * ex.setLastname(nom.get(0).text());
	 * ex.setSpeciality_s(specialite.get(0).text());
	 * 
	 * // String fulladdres = adresse.get(0).text(); // String villeetcode = "";
	 * // String ville = ""; // String rue = ""; // String[] naming2 =
	 * fulladdres.split(",", 2); // villeetcode = naming2[1]; // String[] villes
	 * = villeetcode.split(" ", 3); // ville = villes[2]; // rue = naming2[0];
	 * // Adresse adresses = new Adresse(rue, ville); //
	 * ex.setAdresse(adresses);
	 * 
	 * ex.setPhoto(photo); ex.setProfile(profil);
	 * 
	 * } list.add(ex);
	 * 
	 * }
	 * 
	 * return list;
	 * 
	 * }
	 */

	/*
	 * @Override public ArrayList<Extract> SearchByPlace(String place, int
	 * pagenumber) throws IOException { //
	 * https://www.doctolib.fr/medecin-generaliste/france Document doc; Elements
	 * nom; Elements adresse; Elements specialite; String photo; String profil;
	 * int nb = 0; ArrayList<Extract> list = new ArrayList<>(); String url =
	 * "https://www.doctolib.fr/medecin-generaliste/" + place + "?page=" +
	 * pagenumber; System.out.println(url); doc =
	 * Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get(); Elements
	 * tableRows = doc.getElementsByClass("dl-search-result-presentation");
	 * 
	 * for (Element row : tableRows) { nb++; Extract ex = new Extract();
	 * System.out.println(nb); nom =
	 * row.getElementsByClass("dl-search-result-name").addClass(
	 * "js-search-result-path"); adresse =
	 * row.getElementsByClass("dl-text").addClass("dl-text-body"); specialite =
	 * row.getElementsByClass("dl-search-result-subtitle"); photo =
	 * row.getElementsByTag("img").attr("src"); photo.substring(0); profil =
	 * row.getElementsByTag("a").attr("href"); String p = "";
	 * 
	 * if (!nom.isEmpty() && !specialite.isEmpty()) {
	 * 
	 * ex.setLastname(nom.get(0).text());
	 * ex.setSpeciality_s(specialite.get(0).text());
	 * 
	 * // String fulladdres = adresse.get(0).text(); // String villeetcode = "";
	 * // String ville = ""; // String rue = ""; // String[] naming2 =
	 * fulladdres.split(",", 2); // villeetcode = naming2[1]; // String[] villes
	 * = villeetcode.split(" ", 3); // ville = villes[2]; // rue = naming2[0];
	 * // Adresse adresses = new Adresse(rue, ville); //
	 * ex.setAdresse(adresses);
	 * 
	 * ex.setPhoto(photo); ex.setProfile(profil);
	 * 
	 * } list.add(ex);
	 * 
	 * }
	 * 
	 * return list;
	 * 
	 * }
	 */
	@Override
	public ArrayList<Extract> SearchBySpecialityandPlace(String spec, String place) throws IOException {

		// https://www.doctolib.fr/medecin-generaliste/france
		Document doc;
		Elements nom;
		Elements adresse;
		Elements specialite;
		Element endpage;
		// Element next;
		String photo;
		String profil;
		int pg = 0;
		int nb = 0;
		boolean end = false;
		ArrayList<Extract> list = new ArrayList<>();
		while (end == false) {
			pg++;
			String url = "https://www.doctolib.fr/" + spec + "/" + place + "?page=" + pg;
			doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();

			Elements tableRows = doc.getElementsByClass("dl-search-result-presentation");
			endpage = doc.getElementsByClass("pagination-links").last();

			String next = endpage.getElementsByClass("next").get(0).getElementsByTag("a").attr("href");
			// System.out.println("neex" +
			// endpage.getElementsByClass("next").get(0).getElementsByTag("a").attr("href"));
			if (next.length() == 0) {
				System.err.println("here next");
				end = true;
			}
		}
		int i;
		System.out.println("nombre de pase " + pg);
		////////////////
		for (i = 0; i <= pg; i++) {

			String url = "https://www.doctolib.fr/" + spec + "/" + place + "?page=" + i;
			doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();

			Elements tableRows = doc.getElementsByClass("dl-search-result-presentation");
			endpage = doc.getElementsByClass("pagination-links").last();

			// String next =
			// endpage.getElementsByClass("next").get(0).getElementsByTag("a").attr("href");
			// System.out.println("neex" +
			// endpage.getElementsByClass("next").get(0).getElementsByTag("a").attr("href"));

			for (Element row : tableRows) {

				Extract ex = new Extract();

				nom = row.getElementsByClass("dl-search-result-name").addClass("js-search-result-path");
				adresse = row.getElementsByClass("dl-text").addClass("dl-text-body");
				specialite = row.getElementsByClass("dl-search-result-subtitle");
				photo = row.getElementsByTag("img").attr("src");
				profil = row.getElementsByTag("a").attr("href");

				if (!nom.isEmpty() && !specialite.isEmpty()) {

					//
					// String fulladdres = adresse.get(0).text();
					// String villeetcode = "";
					// String ville = "";
					// String rue = "";
					// String[] naming2 = fulladdres.split(",", 2);
					// villeetcode = naming2[1];
					// String[] villes = villeetcode.split(" ", 3);
					// ville = villes[2];
					// rue = naming2[0];
					// Adresse adresses = new Adresse(rue, ville);
					// ex.setAdresse(adresses);
					//

					ex.setLastname(nom.get(0).text());
					ex.setSpeciality_s(specialite.get(0).text());
					ex.setPhoto(photo);
					ex.setProfile("www.doctolib.fr" + profil);

				}
				list.add(ex);

			}
			// endpage=row.getElementsByClass("pagination-links");

		}
		System.out.println("last" + i);
		return list;

	}

	@Override
	public void test(String e, int b) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("string: " + e + " int: " + b);
	}

	@Override
	public List<AspNetUser> All() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT a.id FROM AspNetUser a where a.discriminator=:type");
		q.setParameter("type", "Doctor");
		// q.setParameter("mdp", mdp);

		System.out.println(q.getResultList());
		return q.getResultList();
	}

	@Override
	public Extract searchexistingdoctor(String nom, String prenom, String specialie, String v) throws IOException {

		String url = "https://www.doctolib.fr/" + specialie + "/" + v + "/" + prenom + "-" + nom;
		System.out.println(url);
		Document doc;
		Elements fullname;
		String lastname = "";
		String firstname = "";
		Elements adresse;
		Elements ad;
		Elements specialite;
		String photo;
		String telephone = "";

		Extract ex = new Extract();

		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(2500000).get();

		Elements tableRows = doc.getElementsByClass("dl-profile-wrapper");
		Elements tableRows2 = doc.getElementsByClass("dl-profile-card");
		Elements tabrow = doc.getElementsByClass("dl-profile-box");
		if (!tableRows.isEmpty() && !tableRows2.isEmpty())

		{
			fullname = tableRows.first().select("span");
			adresse = tableRows2.get(1).getElementsByClass("dl-profile-text");
			ad = tableRows2.get(1).getElementsByClass("dl-profile-doctor-place-map");
			String lat = "" + Double.valueOf(
					doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").substring(
							doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").indexOf("\"lat\":")
									+ 6,
							doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").indexOf(",",
									doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal")
											.indexOf("\"lat\":") + 6)));
			System.out.println(lat);
			String lng = "" + Double.valueOf(
					doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").substring(
							doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").indexOf("\"lng\":")
									+ 6,
							doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").indexOf("}",
									doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal")
											.indexOf("\"lng\":") + 6)));
			System.out.println(lng);
			specialite = tableRows.first().getElementsByClass("dl-profile-header-speciality");
			photo = tableRows.get(0).getElementsByTag("img").attr("src");
			/*
			 * if (!tabrow.isEmpty())
			 * 
			 * { telephone =
			 * tabrow.get(1).getElementsByClass("dl-text dl-text-body").text();
			 * // System.out.println("phone= " + telephone);
			 * ex.setTelephone(telephone); }
			 */
			System.out.println("phone= " + telephone);
			// if (!nom.isEmpty() && !specialite.isEmpty()) {
			String[] naming = fullname.get(0).text().split("[^A-Z]");
			for (String e : naming) {
				if (e.length() > 1)
					lastname = lastname + " " + e;
			}
			firstname = fullname.get(0).text().substring(0, (fullname.get(0).text().length() - lastname.length()));
			// ex.setTelephone(telephone);

			// String adresses = new Adresse(rue, ville);
			// ex.setAdresse(adresses);

			ex.setLastname(lastname);
			ex.setFirstname(firstname);
			ex.setSpeciality_s(specialite.get(0).text());
			ex.setPhoto(photo);
			ex.setLat(lat);
			ex.setLng(lng);

			return ex;
			// }
		} else
			System.out.println("doctor not found in doctlib, please make sure of your name and city");
		return null;

	}

	@Override
	public AspNetUser AddDoctor(String nom, String prenom, String specialie, String ville, String password,
			String email) throws IOException {
	//	Util ut = new Util();
		Extract e = new Extract();
		e = searchexistingdoctor(nom, prenom, specialie, ville);
		if (e != null) {

			AspNetUser user = new AspNetUser();
			// user.setId("39");
			user.setAdress("aaa");
			user.setDiscriminator("Doctor");
			user.setFirstName(e.getFirstname());
			user.setLastName(e.getLastname());
			user.setImageName("www.doctolib.fr" + e.getPhoto());
			user.setPhoneNumber(e.getTelephone());
			user.setEmail(email);
			user.setSpeciality(0);
			// user.addChats1(null);
			user.setAppointments1(null);
			user.setUserName("teeeeetttttt");
			user.setAccessFailedCount(0);
			user.setPhoneNumberConfirmed(true);
			user.setTwoFactorEnabled(false);
			user.setLockoutEnabled(true);
			user.setEmailConfirmed(true);

			// user.set
			user.setPasswordHash((password));

			Extract eee = new Extract();
			eee.setAdresse("aaaaaa");
			eee.setFirstname("eeeeeeeeeeeeeeeee");
			eee.setLastname("aa");
			eee.setLat("lat");
			eee.setLng("eeee");
			eee.setPhoto("photo");
			eee.setProfile("profile");
			eee.setSpeciality_s("5555");
			eee.setTelephone("telephone");
			System.out.println(eee);
			em.persist(user);
			return user;

		} else {
			System.out.println("doctor not found in doctlib, please make sure of your name and city");
		}
		/*
		 * Extract eee = new Extract(); eee.setAdresse("aaaaaa");
		 * eee.setFirstname("eeeeeeeeeeeeeeeee"); eee.setLastname("aa");
		 * eee.setLat("lat"); eee.setLng("eeee"); eee.setPhoto("photo");
		 * eee.setProfile("profile"); eee.setSpeciality_s("5555");
		 * eee.setTelephone("telephone"); System.out.println(eee);
		 * em.persist(eee);
		 */
		return null;
	}

	public List<AspNetUser> getdoctors() {
		List<AspNetUser> doctors = new ArrayList<>();
		TypedQuery<AspNetUser> query = em
				.createQuery("SELECT d FROM AspNetUser d where AspNetUser.discriminator=Doctor", AspNetUser.class);

		return doctors = query.getResultList();

	}

	/*
	 * @Override public Extract profile(String url) throws IOException {
	 * 
	 * System.out.println(url); Document doc; Elements fullname; String lastname
	 * = ""; String firstname = ""; Elements adresse; Elements ad; Elements
	 * specialite; String photo; String telephone = ""; Extract ex = new
	 * Extract(); doc =
	 * Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();
	 * 
	 * Elements tableRows = doc.getElementsByClass("dl-profile-wrapper");
	 * Elements tableRows2 = doc.getElementsByClass("dl-profile-card"); Elements
	 * tabrow = doc.getElementsByClass("dl-profile-box"); if
	 * (!tableRows.isEmpty() && !tableRows2.isEmpty())
	 * 
	 * { fullname = tableRows.first().select("span"); adresse =
	 * tableRows2.get(1).getElementsByClass("dl-profile-text"); ad =
	 * tableRows2.get(1).getElementsByClass("dl-profile-doctor-place-map");
	 * String lat = "" + Double.valueOf(
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * substring(
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * indexOf("\"lat\":") + 6,
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * indexOf(",",
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal")
	 * .indexOf("\"lat\":") + 6))); System.out.println(lat); String lng = "" +
	 * Double.valueOf(
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * substring(
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * indexOf("\"lng\":") + 6,
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal").
	 * indexOf("}",
	 * doc.select(".dl-profile-doctor-place-map-img").attr("data-map-modal")
	 * .indexOf("\"lng\":") + 6))); System.out.println(lng); specialite =
	 * tableRows.first().getElementsByClass("dl-profile-header-speciality");
	 * photo = tableRows.get(0).getElementsByTag("img").attr("src"); if
	 * (!tabrow.isEmpty() && tabrow.size() > 1)
	 * 
	 * { telephone = tabrow.get(1).getElementsByClass("dl-display-flex").text();
	 * ex.setTelephone(telephone); } System.out.println("phone= " + telephone);
	 * 
	 * String[] naming = fullname.get(0).text().split("[^A-Z]"); for (String e :
	 * naming) { if (e.length() > 1) lastname = lastname + " " + e; } firstname
	 * = fullname.get(0).text().substring(0, (fullname.get(0).text().length() -
	 * lastname.length()));
	 * 
	 * String fulladdres = adresse.get(0).text(); String villeetcode = "";
	 * String ville = ""; String rue = ""; String[] naming2 =
	 * fulladdres.split(",", 2); villeetcode = naming2[1]; String[] villes =
	 * villeetcode.split(" ", 3); ville = villes[2]; rue = naming2[0]; //
	 * Adresse adresses = new Adresse(rue, ville); // ex.setAdresse(adresses);
	 * 
	 * ex.setLastname(lastname); ex.setFirstname(firstname);
	 * ex.setSpeciality_s(specialite.get(0).text()); ex.setPhoto(photo);
	 * ex.setLat(lat); ex.setLng(lng);
	 * 
	 * return ex; // } } else System.out.
	 * println("doctor not found in doctlib, please make sure of your name and city"
	 * ); return null;
	 * 
	 * }
	 */

	public void getPDF() throws DocumentException, IOException {
		getPdf p = new getPdf();
		p.Print();
	}

	@Override
	public List<Specialityy> ExtractSpeciality() throws IOException {

		Document doc;
		ArrayList<Specialityy> list = new ArrayList<>();
		String url = "https://www.doctolib.fr/specialities";
		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();
	    Elements tableRowss = doc.getElementsByClass("list-unstyled");
		Elements tableRows = tableRowss.select("li");

		for (Element row : tableRows) { 
			Specialityy sp = new Specialityy();
			// System.out.println("row "+row.text());
			String s = row.getElementsByTag("a").attr("href");
			 System.out.println("element :" + s.substring(1));
			 sp.setName( s.substring(1));
			list.add(sp);
		}
		return list;
	}

	@Override
	public void getFrenshCities() throws  IOException, ParseException, JSONException {
		// TODO Auto-generated method stub
        JSONParser parser = new JSONParser();

		JSONArray a = (JSONArray) parser.parse(new FileReader("c:\\fr.json"));

		  for (Object o : a)
		  {
		    JSONObject person = (JSONObject) o;

		    String name = (String) person.get("city");
		    System.out.println(name);

		    String city = (String) person.get("lag");
		    System.out.println(city);

		    String job = (String) person.get("job");
		    System.out.println(job);

		    
		  }
	}

}