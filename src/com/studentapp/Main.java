package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Main {

	private static List<Student> studentList;
	private static Scanner scan;

	public static void main(String[] args) {

		System.out.println("********* Student Management System *********");
		

		studentList = new ArrayList<Student>();
		scan = new Scanner(System.in);

		while (true) {

			System.out.println("******** Welcome ********");
			System.out.println("Select an option...");
			System.out.println("1. Register a student");
			System.out.println("2. FInd the student with the help of studentID");
			System.out.println("3. List all the information of students");
			System.out.println("4. List STudent information in sorted order");
			System.out.println("5. Exit");

			int option = scan.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scan);
				break;

			case 2:
				findStudentById(scan);
				break;

			case 3:
				printStudentData();
				break;

			case 4:
				sortByName();
				break;

			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option selected!! Please enter value between 1 to 5");
			}
		}

	}

	private static void exit() {
		System.exit(0);

	}

	private static void printStudentData() {
	
		if(studentList.size()>0) {
		System.out.println("----------- PRINTING ALL STUDENT DATA -----------");
		for(Student student : studentList) {
			student.printStudentInfo();
		}

		System.out.println("-----------***************************-----------");
		}else
		{
			System.err.println("Student List is Empty! No student record found!");
		}
	}

	private static void findStudentById(Scanner scan2) {
		Student studentFound = null;

		System.out.println("Enter Student StudentId");
		String studentId = scan2.next();
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.out.println("Student with ID " + studentId + " not found!");
		}
		studentFound.printStudentInfo();

	}

	private static void enrollStudent(Scanner scan2) {
		System.out.println("Enter Student Name...");
		String studentName = scan2.next();

		System.out.println("Enter Student Age...");
		int studentAge = scan2.nextInt();

		System.out.println("Enter Student StudentId...");
		String studentId = scan2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrolled! & enter done to exit");
			String courseName = scan2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break; // exits the loop
			}
			newStudent.enrollCourse(courseName);
		}

		newStudent.printStudentInfo();
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
		printStudentData();
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
