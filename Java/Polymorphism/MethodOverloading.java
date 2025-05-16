package Polymorphism;

class Printer
{
	void print(String doc)
	{
		System.out.println("Priting String : "+doc);
	}
	
	void print(int pages)
	{
		System.out.println("Printing " + pages + " pages ");
	}
	
	void print(String doc, int copies)
	{
		System.out.println("Printing " + copies + " copies of " + doc);
	}
}

public class MethodOverloading {

	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.print("Resume");
		printer.print(10);
		printer.print("Invoice", 2);

	}

}
