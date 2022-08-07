package week1.day1;

public class Car
{
	byte noOfWheels = 4;
	short carNumber = 3425;
	int price = 500000;
	long engineNumber = 356785L;
	float windowSize = 5.5f;
	double seatSize = 15.5;
	boolean isFuelFilled = true;
	char model = '5';
	String carName = "Magnite";
	
	public static void main(String[] args) {
		Car myvechicle = new Car();
		System.out.println(myvechicle.carName);
		
	}
}
