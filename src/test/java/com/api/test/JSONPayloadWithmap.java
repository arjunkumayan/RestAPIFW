package com.api.test;

import net.minidev.json.JSONObject;

public class JSONPayloadWithmap {

	public static void main(String[] args) {

		JSONObject json = new JSONObject();
		json.put("username", "arjun");
		json.put("password", "test@123");
		
		System.out.println(json);
	}

}
