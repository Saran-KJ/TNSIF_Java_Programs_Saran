package com.tnsif.oopsconcept;

public class Encapsulation {
	
	String name;
	int runs;
	int hundred;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getHundred() {
		return hundred;
	}
	public void setHundred(int hundred) {
		this.hundred = hundred;
	}
	
	public String toString() {
		return "Encapsulation[name="+name+",runs="+runs+",hundred="+hundred+"]";
		
	}
	
	
	
	
	

}
