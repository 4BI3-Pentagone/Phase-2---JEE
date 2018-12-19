
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import WebService.clientEmel;
import model.Appointment;
import model.AspNetUser;
import model.Cours;
import model.Step;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clientEmel c = new clientEmel(2);
		try {
			JSONArray json = c
					.readJsonFromUrl("http://localhost:54774/appoi/GetMyCourse?idp=046c1b17-2d4e-4996-92ba-d86c3690e02c"
			// +id
			);
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
