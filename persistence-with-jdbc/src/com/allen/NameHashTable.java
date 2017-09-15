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
		hash.put("Carlos", 4);
		hash.put("Graham", 5);
		hash.put("Hitomi", 6);
		hash.put("JohnH", 7);
		hash.put("JohnL", 8);
		hash.put("Julie", 9);
		hash.put("Leila", 10);
		hash.put("Marc", 11);
		hash.put("Pedro", 12);
		hash.put("Stefan", 13);
		hash.put("Yvonne", 14);
	}
	
}
