package week3.day1;

public class Myhouse {
	public static void main (String[] args)
	{
		//scope restriction
		Plan Land = new Land();
		Land.buildBedRooms(5);
		Land.buildBalcony();
		Land.buildParking();
		Land.buildGarden();
	}

}
