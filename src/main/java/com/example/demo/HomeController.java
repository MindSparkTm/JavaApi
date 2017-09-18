package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
@RestController
public class HomeController {
	@Autowired
	private Restaurantdata rs;
	
	@RequestMapping("/")
	public String Welcome(){
		
		String s = rs.getdata();
		System.out.println(s);
		
		return s;
	}

	
	@RequestMapping(value = "/categorydata", method = RequestMethod.POST,
			consumes = "application/json",
             produces = "application/json")
	public String getinfo(@RequestBody String name) throws JSONException{
		ObjectMapper mapper = new ObjectMapper();
       String s = "";
       Information user=new Information();
		try {
			user = mapper.readValue(name, Information.class);
		     System.out.println(user);
		     System.out.println(user.getName());
			  s= Restaurantdata.getinfo(user.getName());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     System.out.println(s);
		
		 return s;
 
	}
	
	@RequestMapping(value = "/cardenquiry", method = RequestMethod.POST,
			consumes = "application/json")
	public String getOTPandpin(@RequestBody CardStuff stuff) throws JSONException{
		
		String s = Restaurantdata.cardenquiry(stuff.getCardno(), stuff.getCvv(),stuff.getExpiryyear(),stuff.getExpirymonth(),stuff.getPin(),stuff.getTrxreference());
		
		System.out.println("Finally result"+s);
		
		
		
				return s;
		
	
	
 
	}
	
	@RequestMapping(value = "/validateotp", method = RequestMethod.POST,
			consumes = "application/json")
	public String validateOTP(@RequestBody OTPdata data) throws JSONException{
		
		String s = Restaurantdata.validateotpandgetbalance(data.getOtp(), data.getOtptransactionidentifer(),data.getTrxreference());
		
		System.out.println("Finally result"+s);
		
		
		
				return s;
		
	
	
 
	}
}
