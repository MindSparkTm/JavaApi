package com.example.demo;

import java.util.Arrays;
import javax.json.Json;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Component
public class Restaurantdata {
	
	public String getdata(){
		String url = "https://developers.zomato.com/api/v2.1/categories";
	
        RestTemplate rs = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
       
        headers.set("user-key", "2f2d92405140cbdf7066980675644181");
        
        HttpEntity<String> entity = new HttpEntity<String>(headers);

		 HttpEntity<String> result = rs.exchange(url, HttpMethod.GET, entity, String.class); 
		 String body = result.getBody(); 
			    
				
        return body;
		
		
		
		
		
		
	}
	
	
	public static String getinfo(String name) throws JSONException {
		 String jsonString = null;
		 JsonReponse jsonReponse = new JsonReponse();
		    Gson gson = new Gson();

		 
			
		
			if(name.equalsIgnoreCase("Nightclub")) {
				
			    JsonReponse.Data data = jsonReponse.new Data();
			    data.setResponse("sucess");
			    data.setNightclub(Arrays.asList("BrewBistro Lounge","Black Diamond","Privee","B-Club","Havanna"));
			   // data.setRestaurants(Arrays.asList("fjjfjf","kfkfkfk","fjfjjfjf"));
			    jsonReponse.setData(data);
                jsonString = gson.toJson(jsonReponse);
			    System.out.println(gson.toJson(jsonReponse));
				
			}
			
			if(name.equalsIgnoreCase("restaurants")) {
			
				JsonReponse.Data data = jsonReponse.new Data();
			    data.setResponse("sucess");
			    data.setRestaurants(Arrays.asList("Java House","ArtCaffe","KFC","The Carnivore"));
			   // data.setRestaurants(Arrays.asList("fjjfjf","kfkfkfk","fjfjjfjf"));
			    jsonReponse.setData(data);
                jsonString = gson.toJson(jsonReponse);
			    System.out.println(gson.toJson(jsonReponse));				
		
		
				
			}
			
			if(name.equalsIgnoreCase("parks")) {
				
				JsonReponse.Data data = jsonReponse.new Data();
			    data.setResponse("sucess");
			    data.setparks(Arrays.asList("The Nairobi Arboretum","Snake Park","Uhuru Park","Nairobi National Park"));
			   // data.setRestaurants(Arrays.asList("fjjfjf","kfkfkfk","fjfjjfjf"));
			    jsonReponse.setData(data);
                jsonString = gson.toJson(jsonReponse);
			    System.out.println(gson.toJson(jsonReponse));				
		
		
				
			}
			
			if(name.equalsIgnoreCase("telecomprovider")) {
				
				JsonReponse.Data data = jsonReponse.new Data();
			    data.setResponse("sucess");
			    data.settelecom(Arrays.asList("Safaricom","Airtel","Orange"));
			   // data.setRestaurants(Arrays.asList("fjjfjf","kfkfkfk","fjfjjfjf"));
			    jsonReponse.setData(data);
                jsonString = gson.toJson(jsonReponse);
			    System.out.println(gson.toJson(jsonReponse));				
		
		
				
			}
			
			if(name.equalsIgnoreCase("internet")) {
				
				JsonReponse.Data data = jsonReponse.new Data();
			    data.setResponse("sucess");
			    data.setinternet(Arrays.asList("Safaricom 4G","Airtel 4G","Orange","ZuKu Fiber"));
			   // data.setRestaurants(Arrays.asList("fjjfjf","kfkfkfk","fjfjjfjf"));
			    jsonReponse.setData(data);
                jsonString = gson.toJson(jsonReponse);
			    System.out.println(gson.toJson(jsonReponse));				
		
		
				
			}
			
			
			
			
			
			
		
		
			
			
			
		return jsonString;

		
		
		
		
		
		}
		
	
	public static String cardenquiry(String cardnumber,String cvv,String expiryyear,String expirymonth,String pin,String trxreference) {
		String url = "https://prod1flutterwave.co:8181/pwc/rest/card/mvva/cardenquiry";
		String body = "";
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantid","lk_uaPOQTMoiz");
		try {
			params.put("cardno",Encryption.encrypt(cardnumber));
			params.put("cvv",Encryption.encrypt(cvv));
			params.put("expiryyear",Encryption.encrypt(expiryyear));
			params.put("expirymonth",Encryption.encrypt(expirymonth));
			params.put("pin",Encryption.encrypt(pin));
			params.put("trxreference",Encryption.encrypt(trxreference));
			 RestTemplate restTemplate = new RestTemplate();
		     ResponseEntity<String> response = restTemplate.postForEntity(url, params, String.class );

		     body = response.getBody();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
			    
				
       		
		
		
	return body;
	}

	public static String validateotpandgetbalance(String otp,String otptransactionidentifier,String trxreference) {
		String url = "https://prod1flutterwave.co:8181/pwc/rest/card/mvva/cardenquiry/validate";
		String body = "";
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantid","lk_uaPOQTMoiz");
		try {
			params.put("cardno",Encryption.encrypt(otp));
			params.put("cvv",Encryption.encrypt(otptransactionidentifier));
			params.put("expiryyear",Encryption.encrypt(trxreference));

			 RestTemplate restTemplate = new RestTemplate();
		     ResponseEntity<String> response = restTemplate.postForEntity(url, params, String.class );

		     body = response.getBody();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
			    
				
       		
		
		
	return body;
	}

}
