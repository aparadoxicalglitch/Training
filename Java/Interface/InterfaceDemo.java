package Interface;

//Define the Flyable interface
interface Flyable {
 void fly();
 double getMaxAltitude();
}

//Define the Swimmable interface
interface Swimmable {
 void swim();
 double getMaxDepth();
}

//Implement both interfaces in the Duck class
class Duck implements Flyable, Swimmable {
 private String name;
 
 public Duck(String name) {
     this.name = name;
 }
 
 // Implementing methods from Flyable interface
 @Override
 public void fly() {
     System.out.println(name + " is flying through the air");
 }
 
 @Override
 public double getMaxAltitude() {
     return 500.0; // ducks typically fly at around 400-500 meters altitude
 }
 
 // Implementing methods from Swimmable interface
 @Override
 public void swim() {
     System.out.println(name + " is swimming in the water");
 }
 
 @Override
 public double getMaxDepth() {
     return 3.0; // ducks typically dive to around 1-3 meters depth
 }
 
 // Duck-specific method
 public void quack() {
     System.out.println(name + " says: Quack! Quack!");
 }
}

//Test class
public class InterfaceDemo {
 public static void main(String[] args) {
     Duck mallard = new Duck("Mallard");
     
     // Test Duck's behaviors
     mallard.quack();
     mallard.fly();
     System.out.println("Max flying altitude: " + mallard.getMaxAltitude() + " meters");
     mallard.swim();
     System.out.println("Max swimming depth: " + mallard.getMaxDepth() + " meters");
     
     // Demonstrate polymorphism with interfaces
     Flyable flyingObject = mallard;
     flyingObject.fly();
     
     Swimmable swimmingObject = mallard;
     swimmingObject.swim();
 }
}
