package com.markit;

public class WhatDoIDo {
	private X x;
	private boolean b;
	private Object o;
	public WhatDoIDo(X x) { 
		this.x = x; 
		
	}
	
	synchronized Object z() { 
		if (!b) { 
			o = x.y(); 
		b = true; 
		} 
		return o; 
		
	}
	
	public interface X { 
		Object y(); 
	}
	
	public static void main(String args[]){
		
		System.out.println("Hello hw are you!!");
	}
}
