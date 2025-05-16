//Demonstrate polymorphism using Shape → Circle, Rectangle, Triangle. Override area() method

package Polymorphism;

class Shape
{
	double area()
	{
		return 0;
	}
}

class Circle extends Shape
{
	double radius;
	Circle(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	public double area()
	{
		return Math.PI * radius * radius;
	}
}

class Rectangle extends Shape {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;
    
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}


public class Exercise3 {

	public static void main(String[] args) {
		Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0);
        
        // Demonstrate polymorphism - same method call, different behaviors
        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Triangle: " + triangle.area());
        
        Shape[] shapes = {circle, rectangle, triangle};
        
        System.out.println("Calulating areas using an array of shape objects");
        for(Shape shape : shapes) {
            System.out.println("Class: " + shape.getClass().getSimpleName() + ", Area: " + shape.area());
        }
         
	}

}
