/*
import java.io.IOException;
import java.util.ArrayList;

import WebService.clientPost;
import model.Post;

public class PostWs {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
            clientPost c = new clientPost();
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:54774/API/Affichage/?format=json");
            ArrayList<Post> ListPost = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	Post post = new  Post();
            
//winek lenna ? eyy             
            	
            JSONObject obj = (JSONObject)json.get(i);
            post.setTitre(obj.get("Titre").toString());
            post.setMessage(obj.get("Message").toString());
            post.setPostID(obj.get("PostID").toString());
      //      post.setPostedDate(obj.get("date").toString());
            ListPost.add(post);
         }        //    System.out.println("chaima");

            System.out.println(ListPost);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}
*/