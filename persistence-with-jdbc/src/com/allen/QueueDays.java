package com.allen;

import java.util.HashMap;
import java.util.Map;

public class QueueDays {
	public static Map<String, Double> hash = new HashMap<>();

	public static void initHash() {
		hash.put("Alex", (double) 3);
		hash.put("Allen", (double) 4);
		hash.put("April", (double) 3);
		hash.put("Graham", (double) 4);
		hash.put("Hitomi", (double) 2.5);
		hash.put("John H", (double) 0);
		double johnL = 0.5;
		hash.put("John L", (double) 0 * johnL);
		hash.put("Julie", (double) 2);
		hash.put("Leila", (double) 0);
		hash.put("Marc", (double) 3);
		hash.put("Pedro", (double) 3);
		hash.put("Stefan", (double) 1);
		double yvonne = 0.75;
		hash.put("Yvonne", (double) 2 * yvonne);
	}
}
