package oopsconcept;

abstract class Vehicle {
	abstract void speed();
}

class Car extends Vehicle {
	void speed() {
		System.out.println("car is on top speed...");
	}

}

public class Abstraction {
	public static void main(String[] args) {
		Vehicle v=new Car();
		v.speed();
	}
	
	
	

}
