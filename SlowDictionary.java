package com.markit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SlowDictionary {
	private final Map<String,String> dict = new HashMap<String,String>();
	
	public synchronized String translate (String word) throws IllegalArgumentException { 
		if (!dict.containsKey(word)) { 
			
			throw new IllegalArgumentException(word + " not found.");
	} 
		return dict.get(word); 
		
	}
	
	public synchronized void addToDictionary (String word, String translation) throws IllegalArgumentException { 
		if (dict.containsKey(word)) { 
			throw new IllegalArgumentException(word + " already exists."); 
			} 
		dict.put(word,translation); 
		
	}
	
	public synchronized Set<String> getAllWords () { 
		return dict.keySet(); 
		
	}
	
	public static void main(String args[]){
		
		System.out.println("Hello hw are you!!");
	}
}
