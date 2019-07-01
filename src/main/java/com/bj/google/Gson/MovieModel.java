package com.bj.google.Gson;

import java.util.ArrayList;
import java.util.List;
//@JsonIgnoreProperties(ignoreUnknown = true) 
public class MovieModel {
	
	
	public String page;
	public String per_page;
	public int total;
	public int total_pages;
	public List<MovieInfoModel> data = new ArrayList<>();
	

}
