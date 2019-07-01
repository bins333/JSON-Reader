package com.bj.google.Gson;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaHttpJackson {

	static final String URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1";

	static final String JSON_1 = "{\"page\":\"1\",\"per_page\":10,\"total\":13,\"total_pages\":2,\"data\":[{\"Title\":\"Italian Spiderman\",\"Year\":2007,\"imdbID\":\"tt2705436\"},{\"Title\":\"Superman, Spiderman or Batman\",\"Year\":2011,\"imdbID\":\"tt2084949\"},{\"Title\":\"Spiderman\",\"Year\":1990,\"imdbID\":\"tt0100669\"},{\"Title\":\"Spiderman\",\"Year\":2010,\"imdbID\":\"tt1785572\"},{\"Title\":\"Fighting, Flying and Driving: The Stunts of Spiderman 3\",\"Year\":2007,\"imdbID\":\"tt1132238\"},{\"Title\":\"Spiderman and Grandma\",\"Year\":2009,\"imdbID\":\"tt1433184\"},{\"Title\":\"The Amazing Spiderman T4 Premiere Special\",\"Year\":2012,\"imdbID\":\"tt2233044\"},{\"Title\":\"Amazing Spiderman Syndrome\",\"Year\":2012,\"imdbID\":\"tt2586634\"},{\"Title\":\"Hollywood's Master Storytellers: Spiderman Live\",\"Year\":2006,\"imdbID\":\"tt2158533\"},{\"Title\":\"Spiderman 5\",\"Year\":2008,\"imdbID\":\"tt3696826\"}]}";

	static final String JSON_2 = "{\"name\":{\"first\":\"John\",\"last\":\"Doe\"},\"address\":null,\"birthday\":\"1980-01-01\",\"company\":\"Acme\",\"occupation\":\"Software engineer\",\"phones\":[{\"number\":\"000000000\",\"type\":\"home\"},{\"number\":\"999999999\",\"type\":\"mobile\"}]}";

	public static void main(String[] args) {
		readJackson();
	}

	private static void readJackson() {
		ObjectMapper mapper = new ObjectMapper(); 
		
		try {
			MovieModel myModel = mapper.readValue(JSON_1, MovieModel.class);
			System.out.println(myModel.toString());
			
			Map<String, Integer> scoreByName = mapper.readValue(JSON_1, Map.class);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
