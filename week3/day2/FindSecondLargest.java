package week3.day2;

import java.util.ArrayList;
import java.util.TreeSet;

public class FindSecondLargest {
	
	public static void main(String[] args) {

		// Here is the input
		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };
		// Output = 7;

		// Create a empty Set Using TreeSet
		TreeSet<Integer> numbers = new TreeSet<Integer>();

		// Declare for loop iterator from 0 to data.length and add into Set
		for (int i = 0; i < data.length; i++) {
			numbers.add(data[i]);
		}

		// Print the duplicate removed and sorted set
		System.out.println("Tree Set: " + numbers);

		// converted Set into List and print the list
		ArrayList<Integer> arrayList = new ArrayList<Integer>(numbers);
		System.out.println("Converted Set into List Array: " + arrayList);

		// return second highest number from sorted ArrayList
		Integer integer = arrayList.get(arrayList.size() - 2);
		System.out.println("Second Highest Number in List: " + integer);
		
		
	}

}
