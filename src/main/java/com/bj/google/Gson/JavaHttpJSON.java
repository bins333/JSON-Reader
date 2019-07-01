package com.bj.google.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JavaHttpJSON {

	static final String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";

	static final String JSON_1 = "{\"page\":\"1\",\"per_page\":10,\"total\":13,\"total_pages\":2,\"data\":[{\"Title\":\"Italian Spiderman\",\"Year\":2007,\"imdbID\":\"tt2705436\"},{\"Title\":\"Superman, Spiderman or Batman\",\"Year\":2011,\"imdbID\":\"tt2084949\"},{\"Title\":\"Spiderman\",\"Year\":1990,\"imdbID\":\"tt0100669\"},{\"Title\":\"Spiderman\",\"Year\":2010,\"imdbID\":\"tt1785572\"},{\"Title\":\"Fighting, Flying and Driving: The Stunts of Spiderman 3\",\"Year\":2007,\"imdbID\":\"tt1132238\"},{\"Title\":\"Spiderman and Grandma\",\"Year\":2009,\"imdbID\":\"tt1433184\"},{\"Title\":\"The Amazing Spiderman T4 Premiere Special\",\"Year\":2012,\"imdbID\":\"tt2233044\"},{\"Title\":\"Amazing Spiderman Syndrome\",\"Year\":2012,\"imdbID\":\"tt2586634\"},{\"Title\":\"Hollywood's Master Storytellers: Spiderman Live\",\"Year\":2006,\"imdbID\":\"tt2158533\"},{\"Title\":\"Spiderman 5\",\"Year\":2008,\"imdbID\":\"tt3696826\"}]}";

	static final String JSON_2 = "{\"name\":{\"first\":\"John\",\"last\":\"Doe\"},\"address\":null,\"birthday\":\"1980-01-01\",\"company\":\"Acme\",\"occupation\":\"Software engineer\",\"phones\":[{\"number\":\"000000000\",\"type\":\"home\"},{\"number\":\"999999999\",\"type\":\"mobile\"}]}";

	public static void main(String[] args) {
		JSONObject json = new JSONObject(JSON_2);
		//JSONArray array = json.getJSONArray("data");
		Object obj = convertJsonElement(json);
		System.out.println(obj);
	}

	 public static boolean areEqual(Object ob1, Object ob2) throws JSONException {
	        Object obj1Converted = convertJsonElement(ob1);
	        Object obj2Converted = convertJsonElement(ob2);
	        return obj1Converted.equals(obj2Converted);
	    }
	 
	 private static Object convertJsonElement(Object elem) throws JSONException {
	        if (elem instanceof JSONObject) {
	            JSONObject obj = (JSONObject) elem;
	            Iterator<String> keys = obj.keys();
	            Map<String, Object> jsonMap = new HashMap<>();
	            while (keys.hasNext()) {
	                String key = keys.next();
	                jsonMap.put(key, convertJsonElement(obj.get(key)));
	            }
	            return jsonMap;
	        } else if (elem instanceof JSONArray) {
	            JSONArray arr = (JSONArray) elem;
	            Set<Object> jsonSet = new HashSet<>();
	            for (int i = 0; i < arr.length(); i++) {
	                jsonSet.add(convertJsonElement(arr.get(i)));
	            }
	            return jsonSet;
	        } else {
	            return elem;
	        }
	    }
}
