package com.gmail.vsyniakin;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Group saveWorldGroup = new Group("Save world");

		Student student01 = new Student("John", "Mcklein", 43, "male", 3.3);
		Student student02 = new Student("Spider", "Men", 17, "male", 5);
		Student student03 = new Student("Black", "Widow", 30, "female", 4);
		Student student04 = new Student("Mighty", "Thor", 3000, "male", 3.3);
		Student student05 = new Student("Iron", "Men", 40, "male", 5);
		Student student06 = new Student("Sarah", "Connor", 33, "female", 3.5);
		Student student07 = new Student("Lex", "Luthor", 27, "male", 5);
		Student student08 = new Student("Leonardo", "Ninja Turtles", 15, "male", 2.5);
		Student student09 = new Student("Cat", "Woman", 30, "female", 3);
		Student student10 = new Student("Bruce", "Wayne", 40, "male", 4.5);
		Student student11 = new Student("Wonder", "Woman", 2500, "female", 4);
		Student student12 = new Student("John", "Rambo", 35, "male", 3.5);

		try {
			
			saveWorldGroup.addStudent(student01);
			saveWorldGroup.addStudent(student02);
			saveWorldGroup.addStudent(student03);
			saveWorldGroup.addStudent(student04);
			saveWorldGroup.addStudent(student05);
			saveWorldGroup.addStudent(student06);
			saveWorldGroup.addStudent(student07);
			
			saveWorldGroup.addStudentInteractive();
			
			saveWorldGroup.addStudent(student08);
			saveWorldGroup.addStudent(student09);
			saveWorldGroup.addStudent(student10);
			saveWorldGroup.deleteStudent(student07);
			saveWorldGroup.addStudent(student11);
			saveWorldGroup.addStudent(student12);
			
		} catch (FullGroupException e) {
			System.out.println(e.getMessage());
		}
		
		//to lesson 3, 4:
		Student[] findStudent = saveWorldGroup.findStudent("Men");
		for (int i = 0; i < findStudent.length; i++) {
			System.out.println(findStudent[i].toString());
		}
		
		System.out.println(saveWorldGroup.toString());

		saveWorldGroup.sortStudent();

		Student army[] = saveWorldGroup.warriorStudent();

		for (int i = 0; i < army.length; i++) {
			System.out.println(army[i].toString() + " You are the army now! Oh, oh...");
		}
		
		//to lesson 5:
		
		saveWorldGroup.setGroupOutFile();
		Group group1 = Group.getGroupFromFile(new File (".//Group_Save world.txt"));
		System.out.println(group1);
	}
}
