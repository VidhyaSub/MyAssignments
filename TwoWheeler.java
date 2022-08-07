package week1.day1;

public class TwoWheeler {
	int noOfWheels = 2;
	short noOfMirrors = 2;
	long chassisNumber = 3456782L;
	boolean isPunctured = false;
	String bikeName = "Royal Enfield";
	double runningKM = 1000.56;
	
public static void main(String [] args)
{
	TwoWheeler bike = new TwoWheeler();
	System.out.println(bike.noOfWheels);
	System.out.println(bike.noOfMirrors);
	System.out.println(bike.chassisNumber);
	System.out.println(bike.isPunctured);
	System.out.println(bike.runningKM);
}

}
