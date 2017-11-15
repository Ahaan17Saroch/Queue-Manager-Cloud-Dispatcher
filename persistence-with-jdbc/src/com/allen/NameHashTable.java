package com.allen;

import java.util.HashMap;
import java.util.Map;

/*
 * Based on the Alpha sort, this following engineers order was hardcoded.
 * 
 * @author Allen Qian
 */

public class NameHashTable {
	public static Map<String, Integer> hash = new HashMap<>();

	public static void initHash() {
		hash.put("Alex", 1);
		hash.put("Allen", 2);
		hash.put("April", 3);
		hash.put("Graham", 4);
		hash.put("Hitomi", 5);
		hash.put("John H", 6);
		hash.put("John L", 7);
		hash.put("Julie", 8);
		hash.put("Leila", 9);
		hash.put("Marc", 10);
		hash.put("Pedro", 11);
		hash.put("Stefan", 12);
		hash.put("Yvonne", 13);
		hash.put("Ahaan", 14);
	}
	
}
