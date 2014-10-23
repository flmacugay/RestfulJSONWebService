package com.mac.rest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.mac.rest.model.Address;
import com.mac.rest.model.Phone;
import com.mac.rest.model.User;

public enum UserDao {
	
	instance;
	
	private Map<String, User> model = new HashMap<String, User>();

	private UserDao() {
		List<Phone> phones1=new ArrayList<>();
		phones1.add(new Phone("home", "0313241234"));
		phones1.add(new Phone("mobile", "0413241234"));
		User user1=new User(1, "Bill", "Gates", 50, true, null, new Address("123 Windows St", "Melbourne", "VIC"), phones1, new HashSet<>(Arrays.asList("json","rest", "web service")));
		
		List<Phone> phones2=new ArrayList<>();
		phones2.add(new Phone("home", "0300041234"));
		User user2=new User(2, "Mark", "Z", 30, false, "single", new Address("123 Facebook St", "New York", "USA"), phones2, new HashSet<>(Arrays.asList("ejb","servlet")));
		
		List<Phone> phones3=new ArrayList<>();
		phones3.add(new Phone("mobile", "0413241000"));
		User user3=new User(3, "Steve", "Jobs", 60, false, "married", new Address("123 Apple St", "Washington", "USA"), phones3, new HashSet<>(Arrays.asList("html","css","javascript")));
		
		model.put("1", user1);
		model.put("2", user2);
		model.put("3", user3);
	}

	public Map<String, User> getModel() {
		return model;
	}

}
