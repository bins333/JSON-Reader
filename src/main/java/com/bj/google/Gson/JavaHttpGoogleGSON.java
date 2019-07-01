package com.bj.google.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Class which use GSON API to parse JSON over HTTP
 * 
 * @author bins
 *
 */
public class JavaHttpGoogleGSON {

	static final String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";

	public static void main(String[] args) {
		readJSONOverNetwork(URL);
	}

	private static void readJSONOverNetwork(String urlString) {
		String response = null;
		// StringBuilder myBuilder = new StringBuilder();
		try {
			MovieModel myMovie = null;
			URL url = new URL(urlString);

			HttpURLConnection myHttpConnection = (HttpURLConnection) url.openConnection();
			myHttpConnection.setRequestMethod("GET");
			System.out.println("Response code: " + myHttpConnection.getResponseCode() + " Content Type: "
					+ myHttpConnection.getContentType());
			System.out.println("" + myHttpConnection.getResponseMessage());

			BufferedReader reader = new BufferedReader(new InputStreamReader(myHttpConnection.getInputStream()));
			while ((response = reader.readLine()) != null) {
				Gson myGson = new Gson();

				// get complete object
				myMovie = myGson.fromJson(response, MovieModel.class);

				// <start> checking individual entry
				JsonObject myObject = myGson.fromJson(response, JsonObject.class);
				
				System.out.println("Total Pages: " + myObject.get("total_pages").getAsInt());

				JsonArray data = myObject.getAsJsonArray("data");
				for (int i = 0; i < data.size(); i++) {
					String title = data.get(i).getAsJsonObject().get("Title").getAsString();
					//System.out.println(title);
				} // <End>
				
				
				Set<Map.Entry<String, JsonElement>> myset = myObject.entrySet();

				for (Map.Entry<String, JsonElement> myVal : myset) {
					
					convertJsonElement(myObjectList1, myVal.getValue());
					convertJsonElement(myObjectList2, myVal.getValue());
					
				}
				
				myObjectList1.stream().forEach(System.out::println);
				System.out.println(myObjectList1.equals(myObjectList2));
				
				

			}
			reader.close();
			writeGsonObjectToJSON(myMovie);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return myBuilder.toString();
	}

	private static void writeGsonObjectToJSON(MovieModel myMovie) {
		GsonBuilder myBuilder = new GsonBuilder();
		myBuilder.setPrettyPrinting().serializeNulls();
		Gson gson = myBuilder.create();
		// System.out.println(gson.toJson(myMovie));

	}

	static List<Object> myObjectList1 = new ArrayList<>();
	static List<Object> myObjectList2 = new ArrayList<>();

	private static List<Object> convertJsonElement(List<Object> list, Object elem) {
		if(elem instanceof JsonObject) {
			System.out.println("Object 1");
		}
		if (elem instanceof JsonPrimitive) {
			list.add(((JsonElement) elem).getAsString());
		} else if (elem instanceof JsonArray) {
			JsonArray arr = (JsonArray) elem;
			for (int i = 0; i < arr.size(); i++) {
				JsonObject myObjec = (JsonObject) arr.get(i);
				Set<Map.Entry<String, JsonElement>> set = myObjec.entrySet();
				for (Map.Entry<String, JsonElement> myArraySet : myObjec.entrySet()) {
					list.add(myArraySet.getValue().getAsString());
				}
				// list.add(myObjec);
			}
		} else {
			System.out.println(" 000000000 ");
		}
		return list;
	}

}
