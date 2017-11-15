package com.allen;

import java.util.HashMap;
import java.util.Map;

public class QueueDays {
	public static Map<String, Double> hash = new HashMap<>();

	public static void initHash() {
		hash.put("Ahaan", (double) 5);
		
		hash.put("Alex", (double) 5);
		hash.put("Allen", (double) 5);
		hash.put("April", (double) 5);
		hash.put("Graham", (double) 5);
		hash.put("Hitomi", (double) 5);
		hash.put("John H", (double) 5);
		
		hash.put("John L", (double) 5);
		
		hash.put("Julie", (double) 5);
		hash.put("Leila", (double) 5);
		hash.put("Marc", (double) 5);
		hash.put("Pedro", (double) 5);
		hash.put("Stefan", (double) 5);
		
		hash.put("Yvonne", (double) 5);
	}
	
	public static void changeValue(String name, double value) {
		hash.put(name, value);
	}
	
	public static void minusValue(String name) {
		hash.put(name, (double)getValue(name)-0.5);
	}
	
	public static void addValue(String name) {
		hash.put(name, (double)getValue(name)+0.5);
	}
	
	public static double getValue(String name) {
		return hash.get(name);
	}
}
