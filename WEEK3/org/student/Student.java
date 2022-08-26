package org.student;

import org.college.College;
import org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Student Name: Ms.Vidhya");
	}
	public void studentDept() {
		System.out.println("Student Department: IT");
	}
	public void studentId() {
		System.out.println("Student ID: 2006");
	}

	public static void main(String[] args) {
		College college = new College();
		college.collegeCode();
		college.collegeName();
		college.collegeRank();
		
	Department department = new Department();
	department.deptName();
	department.collegeCode();
	department.collegeName();
	department.collegeRank();
	
	Student student = new Student();
	student.studentName();
	student.studentDept();
	student.studentId();
	student.collegeCode();
	student.collegeName();
	student.collegeRank();
	student.deptName();
	
	}
}


