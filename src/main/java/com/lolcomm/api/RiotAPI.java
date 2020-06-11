package com.lolcomm.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@RequestMapping("/api")
@Controller
public class RiotAPI {
	@ResponseBody
	@RequestMapping(value = "/riotAPI" ,produces = "application/json; charset=utf8")
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
