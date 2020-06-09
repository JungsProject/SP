package riot.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RiotAPI {
	@RequestMapping(value = "/riotAPI")
	public void riotAPI (@RequestParam("url") String url, Model model) {
		String message="";
		
		String API_KEY ="RGAPI-2147c3f2-7ff2-47d5-8d2e-2456919a1f97";
		
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
					.addHeader("X-Riot-Token", API_KEY)
					.url(url)
					.build(); //GET Request 
                        
                 
			Response response = client.newCall(request).execute(); 
			 message = response.body().string();
			 System.out.println(message);
			model.addAttribute("message",message);
	}catch (Exception e) {
		e.printStackTrace();
	}
		return;
	}
}
