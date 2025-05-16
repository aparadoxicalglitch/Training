package Abstraction;

interface Payment
{
	void pay();
}

class UPI implements Payment
{
	public void pay()
	{
		System.out.println("Payment is done using UPI");
	}
}

class CreditCard implements Payment
{
	public void pay()
	{
		System.out.println("Payment is done using Credi Card");
	}
}

public class Exercise2 {

	public static void main(String[] args) {
	 
		Payment u = new UPI();
		Payment cc = new CreditCard();
		
		u.pay();
		cc.pay();

	}

}
