package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import emel.Util;

import model.AspNetUser;
import model.Extract;

@Stateless
@LocalBean
public class ExtractionReso implements ExtractionRemote {

	@PersistenceContext(unitName = "PentaEpione-ejb")
	EntityManager em;

	public ExtractionReso() {
		// super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Extract> SearchBySpeciality(String spec, int pagenumber) throws IOException {
		// https://www.doctolib.fr/medecin-generaliste/france
		Document doc;

		Elements nom;
		Elements adresse;
		Elements specialite;
		String photo;
		String profil;
		int nb = 0;
		ArrayList<Extract> list = new ArrayList<>();
		String url = "https://www.doctolib.fr/" + spec + "?page=" + pagenumber;
		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();
		Elements tableRows = doc.getElementsByClass("dl-search-result-presentation");

		for (Element row : tableRows) {
			nb++;
			Extract ex = new Extract();
			System.out.println(nb);
			nom = row.getElementsByClass("dl-search-result-name").addClass("js-search-result-path");
			adresse = row.getElementsByClass("dl-text").addClass("dl-text-body");
			specialite = row.getElementsByClass("dl-search-result-subtitle");
			photo = row.getElementsByTag("img").attr("src");
			profil = row.getElementsByTag("a").attr("href");
			if (!nom.isEmpty() && !specialite.isEmpty()) {

				ex.setLastname(nom.get(0).text());
				ex.setSpeciality_s(specialite.get(0).text());

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

				ex.setPhoto(photo);
				ex.setProfile(profil);

			}
			list.add(ex);

		}

		return list;

	}

	@Override
	public ArrayList<Extract> SearchByPlace(String place, int pagenumber) throws IOException {
		// https://www.doctolib.fr/medecin-generaliste/france
		Document doc;
		Elements nom;
		Elements adresse;
		Elements specialite;
		String photo;
		String profil;
		int nb = 0;
		ArrayList<Extract> list = new ArrayList<>();
		String url = "https://www.doctolib.fr/medecin-generaliste/" + place + "?page=" + pagenumber;
		System.out.println(url);
		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();
		Elements tableRows = doc.getElementsByClass("dl-search-result-presentation");

		for (Element row : tableRows) {
			nb++;
			Extract ex = new Extract();
			System.out.println(nb);
			nom = row.getElementsByClass("dl-search-result-name").addClass("js-search-result-path");
			adresse = row.getElementsByClass("dl-text").addClass("dl-text-body");
			specialite = row.getElementsByClass("dl-search-result-subtitle");
			photo = row.getElementsByTag("img").attr("src");
			photo.substring(0);
			profil = row.getElementsByTag("a").attr("href");
			String p = "";

			if (!nom.isEmpty() && !specialite.isEmpty()) {

				ex.setLastname(nom.get(0).text());
				ex.setSpeciality_s(specialite.get(0).text());

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

				ex.setPhoto(photo);
				ex.setProfile(profil);

			}
			list.add(ex);

		}

		return list;

	}

	@Override
	public ArrayList<Extract> SearchBySpecialityandPlace(String spec, String place, int pagenumber) throws IOException {

		// https://www.doctolib.fr/medecin-generaliste/france
		Document doc;
		Elements nom;
		Elements adresse;
		Elements specialite;
		String photo;
		String profil;
		int nb = 0;
		ArrayList<Extract> list = new ArrayList<>();
		String url = "https://www.doctolib.fr/" + spec + "/" + place + "?page=" + pagenumber;
		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();
		Elements tableRows = doc.getElementsByClass("dl-search-result-presentation");

		for (Element row : tableRows) {
			nb++;
			Extract ex = new Extract();
			System.out.println(nb);
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

			
			 if (!tabrow.isEmpty())
			 
			  { telephone =
			  tabrow.get(1).getElementsByClass("dl-text dl-text-body").text();
			  // System.out.println("phone= " + telephone);
			 ex.setTelephone(telephone); }

			 
			System.out.println("phone= " + telephone);
			// if (!nom.isEmpty() && !specialite.isEmpty()) {
			String[] naming = fullname.get(0).text().split("[^A-Z]");
			for (String e : naming) {
				if (e.length() > 1)
					lastname = lastname + " " + e;
			}
			firstname = fullname.get(0).text().substring(0, (fullname.get(0).text().length() - lastname.length()));
			// ex.setTelephone(telephone);

			String fulladdres = adresse.get(0).text();
			String villeetcode = "";
			String ville = "";
			String rue = "";
			String[] naming2 = fulladdres.split(",", 2);
			villeetcode = naming2[1];
			String[] villes = villeetcode.split(" ", 3);
			ville = villes[2];
			rue = naming2[0];
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
		Util ut = new Util();
		Extract e = new Extract();
		e = searchexistingdoctor(nom, prenom, specialie, ville);
		if (e != null) {

			AspNetUser user = new AspNetUser();
			// user.setId("5z13da36-361b-4a52-b20e-616b95fb3lll");
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
			user.setUserName("teeeeeeeeeeeeeestttttt");
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
			em.persist(eee);
			return user;

		} else {
			System.out.println("doctor not found in doctlib, please make sure of your name and city");
		}

		/*Extract eee = new Extract();

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

		em.persist(eee);
		em.persist(eee);*/
		return null;
	}

	public List<AspNetUser> getdoctors() {
		List<AspNetUser> doctors = new ArrayList<>();
		TypedQuery<AspNetUser> query = em
				.createQuery("SELECT d FROM AspNetUser d where AspNetUser.discriminator=Doctor", AspNetUser.class);

		return doctors = query.getResultList();

	}

	@Override
	public Extract profile(String url) throws IOException {

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
		doc = Jsoup.connect(url).userAgent("Mozilla").timeout(25000).get();

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
			if (!tabrow.isEmpty() && tabrow.size() > 1)

			{
				telephone = tabrow.get(1).getElementsByClass("dl-display-flex").text();
				ex.setTelephone(telephone);
			}
			System.out.println("phone= " + telephone);

			String[] naming = fullname.get(0).text().split("[^A-Z]");
			for (String e : naming) {
				if (e.length() > 1)
					lastname = lastname + " " + e;
			}
			firstname = fullname.get(0).text().substring(0, (fullname.get(0).text().length() - lastname.length()));

			String fulladdres = adresse.get(0).text();
			String villeetcode = "";
			String ville = "";
			String rue = "";
			String[] naming2 = fulladdres.split(",", 2);
			villeetcode = naming2[1];
			String[] villes = villeetcode.split(" ", 3);
			ville = villes[2];
			rue = naming2[0];
			// Adresse adresses = new Adresse(rue, ville);
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


}
