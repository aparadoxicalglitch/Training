package Abstraction;

abstract class Animal
{
	abstract void sound();
	
	void breath()
	{
		System.out.println("Breathing oxygen");
	}
}

class Dog extends Animal
{
	void sound()
	{
		System.out.println("Dog is barking");
	}
}

class Cat extends Animal
{
	void sound()
	{
		System.out.println("Meoww Meoww");
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal obj = new Dog();
//		Dog obj = new Dog();
		obj.sound();
		obj.breath();
		
		Animal cat = new Cat();
		cat.sound();
		cat.breath();

	}

}
