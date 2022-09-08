package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class StringArray {
	public static void main(String[] args) {
	
	List<String> list = new ArrayList<String>();
	list.add("karthi");
	list.add("arun");
	list.add("dev");
	list.add("selva");
	list.add("anbu");
	list.add("sekar");
	
	System.out.println(list);
			
	for(String name:list) {
		if (name.startsWith("s"))
		{
			System.out.println(name);
		}
	}
			
	}
}