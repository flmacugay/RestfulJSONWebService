package com.mac.rest;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class UserStub {
	
	private Map<String, JSONObject> usrMap;
	
	public UserStub() {
		usrMap=new HashMap<>();
		
		try {
			/*
			{
				"firstName" : "Bill",
				"lastName" : "Gates",
				"age" : 50,
				"employee" : false,
				"maritalStatus" : null,
				"address" : {
					"street" : "123 Main St",
					"city" : "Melbourne",
					"state" : "VIC"
					},
				"phone" : [
					{
					"type" : "home",
					"number" : "0313241234"
					},
					{
					"type" : "mobile",
					"number" : "0413241234"
					}
					]
				}
			
			*/
			JSONObject skillsObj = new JSONObject();
			skillsObj.put("1", "java");
			skillsObj.put("2", "html");
			skillsObj.put("3", "css");
			
			JSONObject userObj = new JSONObject();
			userObj.put("name", "froilan");
			userObj.put("age", 34);
			userObj.put("skills", skillsObj);
			
			usrMap.put("1", userObj);
			
			skillsObj = new JSONObject();
			skillsObj.put("1", "jquery");
			skillsObj.put("2", "ejb");
			skillsObj.put("3", "hibernate");
			
			userObj = new JSONObject();
			userObj.put("name", "louie");
			userObj.put("age", 33);
			userObj.put("skills", skillsObj);
			
			usrMap.put("2", userObj);
			
			
			skillsObj = new JSONObject();
			skillsObj.put("1", "json");
			skillsObj.put("2", "oracle");
			skillsObj.put("3", "struts");
			
			userObj = new JSONObject();
			userObj.put("name", "mac");
			userObj.put("age", 32);
			userObj.put("skills", skillsObj);
			
			usrMap.put("3", userObj);
			
		} catch (JSONException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	
	public JSONObject getUser(String userId) {
		return usrMap.get(userId);
	}

	
	public JSONArray getAllUsers() {
		return new JSONArray(usrMap.values());
	}
}
