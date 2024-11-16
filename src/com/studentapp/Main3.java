package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {

		System.out.println("********* Student Management System *********");
		System.out.println("******** Welcome ********");

		studentList = new ArrayList<Student>();

		// Read input from terminal
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Student name");
		String name = scan.next();
		System.out.println("The entered name is "+name);
		
		//to read integer
		System.out.println("Enter student age");
		int age = scan.nextInt();
		System.out.println("The age of student is "+age);

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) {
		 * 
		 * return o1.getName().compareTo(o2.getName()); }
		 * 
		 * };
		 */

		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStidentById(String studentId) {
		Student result = null;

		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.out.println("Student with ID " + studentId + " not found!");
		}
		return result;
	}

}
