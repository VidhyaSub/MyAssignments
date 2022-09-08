package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintDuplicateNumbers {
public static void main(String[] args) {
		
		int[] data = {4,3,6,8,29,1,2,4,7,8};		
		  
		// 1) Regular for loop
		System.out.println("Duplicate elements in given array Using Regular Loop: ");
		 for(int i = 0; i < data.length; i++){
		      for(int j = i + 1; j < data.length; j++){		    	  
		        if(data[i] == data[j]){
		          System.out.println(data[j]);
		        }
		       }
		    } 
		 
		// 2) Using Set
		 Set<Integer> setData = new HashSet<Integer>();
		 System.out.println("Duplicate elements in given array Using Set: ");
		    for(int num : data){		     
		      if(!setData.add(num)){
		        System.out.println(num);
		      }
		    }

	}
}
