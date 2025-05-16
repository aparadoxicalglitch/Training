package Polymorphism;

class Animal
{
	void makeSound()
	{
		System.out.println("Generic animal sound");
	}
}

class Dog extends Animal{
	@Override
	void makeSound()
	{
		System.out.println("Bhaww Bhaww");
	}
}

class Cat extends Animal
{
	@Override
	void makeSound()
	{
		System.out.println("Meow");
	}
}

public class MethodOverriding {

	public static void main(String[] args) {
//		Dog d = new Dog();
		Animal d = new Dog();
		d.makeSound();
		
//		d = new Cat();
//		d.makeSound();
		Cat c = new Cat();
		c.makeSound();

	}

}
