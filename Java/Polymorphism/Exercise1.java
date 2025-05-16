package Polymorphism;
 
class Calculator {
    // Addition operations
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public double add(double a, double b, double c) {
        return a + b + c;
    }
    
    // Subtraction operations
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    // Multiplication operations
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
    
    public double multiply(double a, double b, double c) {
        return a * b * c;
    }
    
    // Division operations
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
    
public class Exercise1
{
	public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Testing addition
        System.out.println("Integer Addition: " + calc.add(5, 3));
        System.out.println("Double Addition: " + calc.add(5.5, 3.3));
        System.out.println("Triple Integer Addition: " + calc.add(5, 3, 2));
        
        // Testing subtraction
        System.out.println("Integer Subtraction: " + calc.subtract(5, 3));
        System.out.println("Double Subtraction: " + calc.subtract(5.5, 3.3));
        
        // Testing multiplication
        System.out.println("Integer Multiplication: " + calc.multiply(5, 3));
        System.out.println("Double Multiplication: " + calc.multiply(5.5, 3.3));
        System.out.println("Triple Integer Multiplication: " + calc.multiply(5, 3, 2));
        
        // Testing division
        System.out.println("Integer Division: " + calc.divide(6, 3));
        System.out.println("Double Division: " + calc.divide(7.5, 2.5));
        
        // Testing division by zero exception
        try {
            calc.divide(5, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
