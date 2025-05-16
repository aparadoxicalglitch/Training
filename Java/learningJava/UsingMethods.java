package learningJava;
import java.util.Scanner;

public class UsingMethods {
	
	static void print1()
	{
		System.out.println("Hello I am print1 function");
	}
	
	public void print2()
	{
		System.out.println("Hello I am print2 function");
	}
	
	
	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		Methods m = new Methods();
		UsingMethods um = new UsingMethods();
		
//		System.out.println("Enter two numbers ");
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int add = m.add(a, b);
//		System.out.println(add);
		
		m.x = "Bye";
//		m.x1 = "Bye";
		
		System.out.println(m.x);
		m.print();
		print1();
		um.print2();
		
	}

}
