package BeanEmel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.parser.ParseException;

import com.itextpdf.text.DocumentException;

import model.Adresse;
import model.AspNetUser;
import model.Extract;
import model.Specialityy;

@Remote
public interface ExtractionRemote {
	// public ArrayList<Extract> SearchBySpeciality(String speciality,int
	// pagenumber) throws IOException;
	// public ArrayList<Extract> SearchByPlace(String place,int pagenumber)
	// throws IOException;
	public ArrayList<Extract> SearchBySpecialityandPlace(String spec, String place) throws IOException;

	public Extract searchexistingdoctor(String nom, String prenom, String specialie, String ville) throws IOException;

	public List<AspNetUser> All();

	public AspNetUser AddDoctor(String nom, String prenom, String specialie, String ville, String password,
			String email) throws IOException;

	public void test(String e, int b) throws IOException;

	// public Extract profile(String url) throws IOException ;
	public void getPDF() throws DocumentException, IOException;

	public List<Specialityy> ExtractSpeciality() throws IOException;

	public List<Adresse> getFrenshCities() throws IOException, ParseException, JSONException;
}
