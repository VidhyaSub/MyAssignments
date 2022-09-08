package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class Assignment2 {
	public static void main(String[] args)
	{
		int i=0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(22);
		list.add(3);
		list.add(54);
		list.add(65);
		list.add(22);
		list.add(43);
		
		for (int li:list)
		{
			if (li==22)
			i=i+1;
			
		}
		System.out.println("The No. of Occurances of 22 in the list is " + i);
				
	}

}
