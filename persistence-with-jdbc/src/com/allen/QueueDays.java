package com.allen;

import java.util.HashMap;
import java.util.Map;

public class QueueDays {
	public static Map<String, Double> hash = new HashMap<>();

	public static void initHash() {
		hash.put("Alex", 1.5);
		hash.put("Allen", (double) 5);
		hash.put("April", (double) 3);
		hash.put("Graham", (double) 4);
		hash.put("Hitomi", (double) 2);
		hash.put("John H", (double) 0);
		double johnL = 0.5;
		hash.put("John L", (double) 3 * johnL);
		hash.put("Julie", (double) 0);
		hash.put("Leila", (double) 2);
		hash.put("Marc", (double) 2);
		hash.put("Pedro", (double) 4);
		hash.put("Stefan", (double) 5);
		double yvonne = 0.75;
		hash.put("Yvonne", (double) 3 * yvonne);
	}
}
