package com.studentapp;

public class Main {

	public static void main(String[] args) {

		System.out.println("********* Student Management System *********");
		System.out.println("******** Welcome ********");
		
		Student s1;
		s1 = new Student("Sushmita More",22, "S-1");
		
		s1.enrollCourse("Java");
		//s1.enrollCourse("Java");
		s1.enrollCourse("DevOps");
		//s1.enrollCourse("C++");
		s1.enrollCourse("DSA");
		//System.out.println(s1);   // this prints toString method
		s1.printStudentInfo();
		
		Student s2 = new Student("Omkar",25,"S-24");
		s2.enrollCourse("DSA");
		//System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("Shubh",26,"S-28");
		s3.printStudentInfo();
		s3.enrollCourse("Java");
		//System.out.println(s3);
		
	}

}
