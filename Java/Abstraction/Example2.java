package Abstraction;

interface Shape {
    double area();
}

class Circle implements Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape{
	int length;
	
	Square(int l){
		length = l;
	}
	
	public double area()
	{
		return length * length;
	}
}

public class Example2 {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        System.out.println("Area: " + c.area());
        
        Shape sq = new Square(3);
        System.out.println("Area: " + sq.area());
    }
}
