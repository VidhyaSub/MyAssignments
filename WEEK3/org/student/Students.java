package student;

import org.bank.AxisBank;

public class Students {

public void getStudentInfo(int id)
	
	{
		System.out.println("Below is the output of overloaded method with id args alone");
		System.out.println("The ID of Student is "+ id);
	}
public void getStudentInfo(int id,String name)

{		System.out.println("");
        System.out.println("Below is the output of overloaded method with id and name args ");
	    System.out.println("The ID and Name of student are "+ id+" and "+name);
	
}

public void getStudentInfo(String email,int phonenumber)

{		System.out.println("");
        System.out.println("Below is the output of overloaded method with email and phone number args ");
	    System.out.println("The email of Student is "+ email);
	    System.out.println("The Phone number of Student is " +phonenumber);
	
}

public static void main(String[] args) {

	Students stud= new Students();
	stud.getStudentInfo(195);
	stud.getStudentInfo(195, "Vidhya");
	stud.getStudentInfo("vidhyasub@gmail.com", 999488739);
}
}
