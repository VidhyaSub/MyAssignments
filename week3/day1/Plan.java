package week3.day1;

public interface Plan {
	//will contain only the blueprint
	// * only abstract methods
	   /**
	    * This method build the bedroom which is east facing in 140 sqfts with attached T&B and wardrobe for storage
	    * @author LT-VIDHS
	    * @param numbers -> the number of bedrooms that a house should have
	    * 
	    */
	public void buildBedRooms(int numbers);
	/**
	    * 
	    * 
	    */
	public void buildBalcony();
	/**
	 * 
	 */
	public void buildParking();
	// *static final variables
	int totalSqft = 1800;
	String name = "7 wonders";
	String[] flats = {"F1","F2","F3","S1","S2","S3","G1"};
	
	public void buildGarden();

}

