package week3.day1;

public class Runner {
public static void main (String[] args) {
	BMW bmw = new BMW();
	bmw.autopark();
	bmw.applyBreak();
	bmw.powerSteering();
	System.out.println("This is BMW");
	
	Audi aud = new Audi ();
	aud.musicpalyer();
	aud.powerSteering();
	aud.applyBreak();
	System.out.println("This is Audi");
	
	Bajaj baj = new Bajaj();
	baj.applyBreak();
	baj.handStart();
	baj.reverseGearing();
	baj.soundHorn();
	System.out.println("This is Bajaj");
}
}
