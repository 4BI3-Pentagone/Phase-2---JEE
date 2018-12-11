
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import WebService.clientEmel;
import model.AspNetUser;
import model.Cours;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
clientEmel c = new clientEmel(2);
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:54774/API/Affichage/?format=json");
            ArrayList<AspNetUser> listePatient = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	AspNetUser patient = new  AspNetUser();
            
            
            	
            JSONObject obj = (JSONObject)json.get(i);
            
            
            patient.setFirstName(obj.get("FirstName").toString());
            patient.setId(obj.get("Id").toString());
            patient.setEmail(obj.get("Email").toString());
     //       patient.setBirthDate(obj.get("birthDate").toString());
            patient.setLastName(obj.get("lastName").toString());
            patient.setImageName(obj.get("ImageName").toString());
           // patient.setCours1(obj.get("course").toString());
            listePatient.add(patient);
         }
            System.out.println(listePatient);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}
