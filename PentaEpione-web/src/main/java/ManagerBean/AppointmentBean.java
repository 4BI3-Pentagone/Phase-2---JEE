package ManagerBean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.print.attribute.standard.DateTimeAtCompleted;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import BeanEmel.clientEmel;
import model.Appointment;
import model.AspNetUser;

@ManagedBean(name = "appService") 
public class AppointmentBean {
     
    
    public List<Appointment> createAppoint() {
        List<Appointment> list = new ArrayList<Appointment>(); 
        clientEmel c= new clientEmel(2);
		try {
	
			JSONArray json = c.readJsonFromUrl("http://localhost:54774/appoi/GetMyCourse?idp=8978b457-fd9f-4e49-88fa-6330cd2c8ffa");
			//
			ArrayList<Appointment> listeViste = new ArrayList<>();
			// Cours c =new Cours();
			for (int i = 0, count = json.length(); i < count; i++) {
				Appointment a = new Appointment();

				JSONObject obj = (JSONObject) json.get(i);
				
				//a.setAspNetUser1((AspNetUser) obj.get ("patient")); 
				a.setDisease(obj.get("Disease").toString());
				a.setAppointmentId(obj.getInt("AppointmentId"));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				SimpleDateFormat dop = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				Date d = (Date) df.parse(obj.getString("Date").toString());
				String FinaleDate = dop.format(d);
				a.setDate(d); 
				a.setState(obj.getInt("state")); 
				a.setRate(obj.getInt("Rate"));
				//a.setRate(2);
				list.add(a);

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
		
        Date d = new Date(2018, 12, 19);
        //list.add(new Appointment(getRandomYear(),d, getRandomColor(), getRandomPrice() ));
        return list;
    }
    
    
}