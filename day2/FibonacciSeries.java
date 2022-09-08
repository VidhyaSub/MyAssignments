package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int firstNumber=0, secondNumber=1, sum=0;
		System.out.println(firstNumber+"\n" +secondNumber);
for(int i=1; i<=9; i++) {
			
			/*Add first and second number assign to sum
			  Assign second number to the first number
			  Assign sum to the second number
			  Print sum*/
			
			sum = firstNumber+secondNumber;
			System.out.println(sum);
			firstNumber=secondNumber;
			secondNumber=sum;
			
		}

	
	}
}
