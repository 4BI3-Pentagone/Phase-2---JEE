/*package parse;

import org.json.*;


public class JsonParsPost {
	 
	
	 
	 //Pour l'authentification
	    public static String constructJSON(String Message, boolean Etat) {
	        JSONObject obj = new JSONObject();
	        try {
	            obj.put("Message", Message);
	            obj.put("Status", new Boolean(Etat));
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	        }
	        return obj.toString();
	    }
	 
	  
	    
	    public static String constructJSON(String tag, boolean status,String err_msg) {
	        JSONObject obj = new JSONObject();
	        try {
	            obj.put("tag", tag);
	            obj.put("status", new Boolean(status));
	            obj.put("error_msg", err_msg);
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	        }
	        return obj.toString();
	    }
	   
	 
}
*/