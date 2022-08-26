package org.bank;

public class AxisBank extends BankInfo {
	public void deposit()
	{   
				System.out.println("This is for axis bank Deposit");
	}

public void ThisandSuper()
{
	System.out.println("The below are the output of method ThisandSuper --1st is output of this and 2nd is output of super");
	{
		this.deposit();
		super.deposit();
	}
}
	public static void main(String[] args) {

		AxisBank axis= new AxisBank();
		System.out.println("The below is the ouput of overriden method");
		System.out.println("");
		axis.deposit();
		axis.ThisandSuper();
		
	}
	}