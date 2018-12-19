package BeanEmel;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import WebService.clientEmel;
import model.Appointment;
import model.AspNetUser;
import model.Cours;
import model.Step;

/**
 * Session Bean implementation class PatBean
 */
@Stateless
@LocalBean
public class PatBean implements PatBeanRemote, PatBeanLocal {

    /**
     * Default constructor. 
     */
    public PatBean() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void getPatient(String id){   
    	clientEmel c = new clientEmel(2);
    try {
                JSONArray json = c.readJsonFromUrl("http://localhost:54774/appoi/GetMyPatients?id="+id);
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
               Cours c1= new Cours();
                JSONObject cour=obj.getJSONObject("couse");
                c1.setCourseId(cour.getInt("CourseId"));
                //(obj.get("course").toString());
               patient.setCours1(c1);
                listePatient.add(patient);
             }
                System.out.println(listePatient);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void getTreatment(String idp){   
    	clientEmel c = new clientEmel(2);
    try {
                JSONArray json = c.readJsonFromUrl("http://localhost:54774/appoi/GetMyTreatment?idp="+idp);
                ArrayList<Step> listeTraitement= new  ArrayList<>();
                for (int i = 0, count = json.length(); i < count; i++) {
                	Step s = new  Step();
                
                
                	
                JSONObject obj = (JSONObject)json.get(i);
                
                
                s.setStepId(obj.getInt("StepId"));
                s.setState(obj.getInt("state"));
                s.setTreatment(obj.get("treatment").toString());
               // patient.setCours1(obj.get("course").toString());
             //   listePatient.add(patient);
                listeTraitement.add(s);
             }
                System.out.println(listeTraitement);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void getCourse(String id){    clientEmel c = new clientEmel(2);
    try {
                JSONArray json = c.readJsonFromUrl("http://localhost:54774/appoi/GetMyCourse?idp="+id);
                ArrayList<Appointment> listeViste = new ArrayList<>();
    			// Cours c =new Cours();
    			for (int i = 0, count = json.length(); i < count; i++) {
    				Appointment a = new Appointment();

    				JSONObject obj = (JSONObject) json.get(i);
    				a.setDisease(obj.get("Disease").toString());
    				a.setAppointmentId(obj.getInt("AppointmentId"));
    				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    				SimpleDateFormat dop = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    				Date d = (Date) df.parse(obj.getString("Date").toString());
    				String FinaleDate = dop.format(d);
    				a.setDate(d);
    				a.setState(obj.getInt("state"));
    				// a.setAspNetUser2(aspNetUser2);
    				listeViste.add(a);
             
             }
                System.out.println(listeViste);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
