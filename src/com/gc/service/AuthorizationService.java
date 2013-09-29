package com.gc.service;

import java.util.HashMap;
import java.util.Map;

public class AuthorizationService {
	private Map<String, String> users = new HashMap<>();
	{
		users.put("admin", "admin");
		users.put("root", "12345");
	}
	
	public boolean authenticate(String userId, String password) {
		return isUserExists(userId, password) ? true : false;
	}

	private boolean isUserExists(String userId, String password) {
		return users.containsKey(userId) && users.get(userId)!=null && users.get(userId).equals(password);
	}
}
