package com.myproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
		@ResponseBody
		@RequestMapping("/riotAPI")
		public String riotAPI (@RequestParam("url") String url) {
			String message="";
			
			String API_KEY ="RGAPI-822ddabc-8aa1-4ee0-960a-7d0a41e8530e";
			
			try {
				OkHttpClient client = new OkHttpClient();
				Request request = new Request.Builder()
						.addHeader("X-Riot-Token", API_KEY)
						.url(url)
						.build(); //GET Request 
	                        
	                 
				Response response = client.newCall(request).execute(); 
				 message = response.body().string();
				 
		}catch (Exception e) {
			e.printStackTrace();
		}
			return message;
		}
	
}
