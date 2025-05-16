package Abstraction;

abstract class Vehicle
{
	abstract void fuelType();
	
	public void startEngine()
	{
		System.out.println("Starting Engine");
	}	
}

class Car extends Vehicle
{
	void fuelType()
	{
		System.out.println("Car is Disel Type");
	}
	
	public void carModel()
	{
		System.out.println("Fortuner");
	}
}

class Bike extends Vehicle
{
	void fuelType()
	{
		System.out.println("Bike is Petrol Type");
	}
	
	public void bikeModel()
	{
		System.out.println("Royal Enfield Hunter");
	}
}

public class Exercise1 {

	public static void main(String[] args) {
		
		Vehicle car = new Car();
		Vehicle bike = new Bike();
		
		car.fuelType();
		car.startEngine();
//		car.carModel();
		
		bike.fuelType();
		bike.startEngine();
//		bike.bikeModel();
		
	}

}
