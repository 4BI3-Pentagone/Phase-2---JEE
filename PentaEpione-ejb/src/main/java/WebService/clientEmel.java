package WebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;

public class clientEmel {

	/*try {
        JSONArray json = readJsonFromUrl("http://url.com/api/objects/?format=json");
        JSONObject obj = (JSONObject)json.get(5);
        System.out.println(obj.get("title"));
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }*/
int a;

	/*
	public static JSONArray readJsonFromUrl(String url) throws IOException {
	        // String s = URLEncoder.encode(url, "UTF-8");
	        // URL url = new URL(s);
	        InputStream is = new URL(url).openStream();
	        JSONArray json = null;
	        try {
	            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	            String jsonText = readAll(rd);
	            json = new JSONArray(jsonText);
	        } catch (JSONException e) {
	            e.printStackTrace();
	        } finally {
	            is.close();
	        }
	        return json;
	    }*/
}
