package Polymorphism;

class Vehicle{
	
	void run()
	{
		System.out.println("Vehicle is running");
	}
	
}

class Car extends Vehicle
{
	@Override
	public void run()
	{
		System.out.println("Car is running");
	}
}

class Bike extends Vehicle
{
	@Override
	public void run()
	{
		System.out.println("Bike is running");
	}
}

public class Exercise2 {

	public static void main(String[] args) {
		Car c = new Car();
		c.run();
		Bike b = new Bike();
		b.run();

	}

}
