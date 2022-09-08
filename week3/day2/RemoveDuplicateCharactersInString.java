package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersInString {
public static void main(String[] args) {
		
		String orignalString = "PayPal India";
		System.out.println("Input String : " + orignalString);

		StringBuilder builder = new StringBuilder();
		Set<Character> set = new HashSet<Character>();

		char[] chars = orignalString.toCharArray();

		for (char ch : chars) {

			if (set.add(ch)) {
				builder.append(ch);
			}
		}		
		System.out.println("After removing the duplicates : " + builder.toString());

	}


}
