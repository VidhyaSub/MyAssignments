package week1.day2;

import java.util.Scanner;

public class CheckIfTheNumberIsPrimeOrNot {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);	
		System.out.println("Enter a Number: ");
		int num = in.nextInt();
		
		if(isPrime(num)) {
			System.out.println("Prime Number");
		}else {
			System.out.println("Not Prime Number");
		}		
	}
	
	public static boolean isPrime(int num) {
		
		boolean flag = true; //Assume that input is prime
		
		//edge case
		if (num<=1) {
			flag=false;
		}
		
		//Loop through all numbers between 2 and num
		for (int i=2; i<(num);i++) {
			if(num%i==0) {
				 /*
                 *If num is divisible by any number other than 1 and itself-then, it is Not Prime
                 */
				flag = false;
				break; //since the number is not prime, so no use of iterating further
			}
		}
	return flag;

	}


}
