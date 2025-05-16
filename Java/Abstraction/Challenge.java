package Abstraction;

// Interface Playable with play(). Abstract class Instrument with tune(). Create Guitar and Piano that use both.

abstract class Instrument
{
	abstract void tune();
}

interface Playable
{
	void play();
}

class Guitar extends Instrument implements Playable
{
	public void tune()
	{
		System.out.println("Tuining Guitar");
	}
	
	public void play()
	{
		System.out.println("Playing Guitar");
	}
}

class Piano extends Instrument implements Playable
{
	public void tune()
	{
		System.out.println("Tuning piano");
	}
	
	public void play()
	{
		System.out.println("Playing Piano");
	}
}


public class Challenge {

	public static void main(String[] args) {
		
		Instrument g = new Guitar();
		Playable gp = new Guitar();
		Instrument p = new Piano();
		Playable pp = new Piano();
		
		g.tune();
		gp.play();
		
		p.tune();
		pp.play();

	}

}
