package learningJava.Constructor;

//public class Main {
//	int x ;
//	
//	public Main(int y)
//	{
////		x = 5;
//		x = y;
//	}
//
//	public static void main(String[] args) {
//		Main obj = new Main(7);
//		System.out.println(obj.x);
//	}
//
//}
public class Main {
	  int modelYear;
	  String modelName;

	  public Main(int year, String name) {
	    modelYear = year;
	    modelName = name;
	  }

	  public static void main(String[] args) {
	    Main myCar = new Main(1969, "Mustang");
	    System.out.println(myCar.modelYear + " " + myCar.modelName);
	  }
	}