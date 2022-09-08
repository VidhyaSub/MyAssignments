package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
	public static void main(String[] args) {
		
		 List<Integer> list1 = new ArrayList<Integer>();
		 list1.add(3);
		 list1.add(2);
		 list1.add(11);
		 list1.add(4);
		 list1.add(6);
		 list1.add(7);		 
		 System.out.println("List 1 array: "+list1);		 
		 
	     List<Integer> list2 = new ArrayList<Integer>();
	     list2.add(1);
	     list2.add(2);
	     list2.add(8);
	     list2.add(4);
	     list2.add(9);
	     list2.add(7);
	     System.out.println("List 2 array: "+list2);	
	     
	     List<Integer> list3 = new ArrayList<Integer>();
	     
	     for (int i=0;i<list1.size();i++) {
	    	 int arr1=list1.get(i);
	    	 for (int j=0;j<list2.size();j++) {
	    		 int arr2=list2.get(j);
	    		 if (arr1==arr2) {	    			 
	    			 list3.add(arr2);
	    		 }
	    	 }	    	
	     }
	     System.out.println("Intersection are: "+list3);
	}

}
