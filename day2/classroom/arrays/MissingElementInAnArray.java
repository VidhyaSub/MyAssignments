package week1.day2.classroom.arrays;

import java.util.Arrays;

public class MissingElementInAnArray {
	public static void main(String[] args) {
		// Here is the input
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		for (int i=0; i<arr.length-1; i++) {
			if (arr[i]+1!=arr[i+1]) {
				System.out.println("Missing number in an array: "+(arr[i]+1));
				break;
			}
		}
		}


}
