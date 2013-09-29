package com.gc.service;

import java.util.HashMap;
import java.util.Map;

import com.gc.domain.UserDetails;

public class AuthorizationService {
	private Map<String, UserDetails> users = new HashMap<>();
	{
		users.put("admin", new UserDetails("admin", "admin", "Vasiliy Popkin"));
		users.put("root", new UserDetails("root", "12345", "John Smith"));
	}

	public boolean authenticate(String userId, String password) {
		return isUserExists(userId, password) ? true : false;
	}

	private boolean isUserExists(String userId, String password) {
		return users.containsKey(userId) && users.get(userId) != null
				&& users.get(userId).getPassword() != null
				&& users.get(userId).getPassword().equals(password);
	}

	public UserDetails getUserDetails(String userId) {
		return users.get(userId);
	}
}
