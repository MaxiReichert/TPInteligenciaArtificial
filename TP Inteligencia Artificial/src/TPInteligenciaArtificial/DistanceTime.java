package TPInteligenciaArtificial;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DistanceTime {

    private static final String API_KEY="AIzaSyDySi3Qt47MglUfviVb7D81yniPZK1W3ys";
    OkHttpClient client = new OkHttpClient();
    
    public DistanceTime() {
	}

	public Long[] calculate(String source ,String destination) throws IOException {
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
					+ source + "&destinations=" + destination + "&key=" + API_KEY;
	    Request request = new Request.Builder()
	        .url(url)
	        .build();
	    Response response = client.newCall(request).execute();
	    
	    /*
	     * La respuesta es un JSON, por lo tanto, se debe parsear a un objeto JAVA
	     */
	    JSONParser parser = new JSONParser();
        try {
         Object obj = parser.parse(response.body().string());
         JSONObject jsonobj = (JSONObject)obj;
         JSONArray rows = (JSONArray)jsonobj.get("rows");
         JSONObject jsonobj2 = (JSONObject)rows.get(0);
         JSONArray elements =(JSONArray)jsonobj2.get("elements");
         JSONObject jsonobj3 = (JSONObject)elements.get(0);
         JSONObject distance = (JSONObject)jsonobj3.get("distance");
         JSONObject time = (JSONObject)jsonobj3.get("duration");
         
         System.out.println(distance.get("text"));
         System.out.println(time.get("text"));
         
         Long[] result = {Long.parseLong(distance.get("value").toString()),
        		 Long.parseLong(time.get("value").toString())};
         return result;
	    } catch(Exception e) {
		    e.printStackTrace();
		}
        
        return null;
	}

}
