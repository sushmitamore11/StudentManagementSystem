package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	
	private static List<Student> studentList;

	public static void main(String[] args) {

		System.out.println("********* Student Management System *********");
		System.out.println("******** Welcome ********");
		
		studentList = new ArrayList<Student>();
		
		
		Student s1;
		s1 = new Student("Sushmita More",22, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("DSA");

		Student s2 = new Student("Omkar",25,"S-24");
		s2.enrollCourse("DSA");

		Student s3 = new Student("Shubh",26,"S-28");
		s3.enrollCourse("Java");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		Student result = findStidentById("S-4");
		System.out.println("Result "+result);
		sortByName();
		
	}
	
	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
				/*
				 * new Comparator<Student>() {
				 * 
				 * @Override public int compare(Student o1, Student o2) {
				 * 
				 * return o1.getName().compareTo(o2.getName()); }
				 * 
				 * };
				 */
		
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStidentById(String studentId) {
		Student result = null;
		
		try {
		result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No data found!!"));
		}
		catch(RuntimeException e) {
			System.out.println("Student with ID "+studentId+" not found!");
		}
		return result;
	}

}
