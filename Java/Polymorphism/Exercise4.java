package Polymorphism;

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

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
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

public class Exercise4 {
    public static void draw(Shape s) {
        System.out.printf("Drawing %s | Area: %.2f\n", s.getClass().getSimpleName(), s.area());
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0);

        System.out.println("Using draw method (polymorphism):");
        draw(circle);
        draw(rectangle);
        draw(triangle);

        Shape[] shapes = {circle, rectangle, triangle};
        System.out.println("\nUsing array of Shape references:");
        for (Shape shape : shapes) {
            System.out.printf("Class: %s, Area: %.2f\n", shape.getClass().getSimpleName(), shape.area());
        }
    }
}
