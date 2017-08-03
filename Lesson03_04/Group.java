package com.gmail.vsyniakin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Group {

	private String nameOfGroup;
	private Student[] student = new Student[10];
	private int index = 0;

	public Group(String nameOfGroup) {
		super();
		this.nameOfGroup = nameOfGroup;
	}

	public Group() {
		super();
	}

	public void addStudent(Student student) throws FullGroupException {
		try {
			if ((student.getFirstName() == null) || (student.getSecondName() == null) || (student.getAge() == 0) || (student.getSex() == null) || (student.getAvarageScore() == 0)) {
				throw new NullPointerException();
			}
			if (checkStudentInGroup(student)) {
				if (this.index >= this.student.length)
					throw new FullGroupException();
				this.student[index] = student;
				this.index++;
			}
		} catch (NullPointerException e) {
			System.out.println(e + " - Student parameter invalid!");
		}
	}

	public void addStudentInteractive() {
		Student studentIn = new Student();

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Name: ");
			studentIn.setFirstName(sc.nextLine());

			System.out.println("Second name: ");
			studentIn.setSecondName(sc.nextLine());

			System.out.println("Age: ");
			studentIn.setAge(Integer.parseInt(sc.nextLine()));

			System.out.println("Sex: ");
			studentIn.setSex(sc.nextLine());

			System.out.println("Avarage score: ");
			studentIn.setAvarageScore(Double.parseDouble(sc.nextLine()));

		} catch (NumberFormatException e) {
			System.out.println("Not the correct number format, please enter correct data!");
			addStudentInteractive();
			studentIn.setFirstName(null);
		}

		addStudent(studentIn);
	}

	public void sortStudent() {
		System.out.println("Sort by: 0 - firstName, 1 - secondName, 2 - age, 3 - avarageScore");
		Student.setSortParameter(-1);
		Scanner sc = new Scanner(System.in);

		try {
			Student.setSortParameter(Integer.parseInt(sc.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Incorrect choice.");
		}
		sc.close();
		if ((Student.getSortParameter() < 0) || (Student.getSortParameter() > 3)) {
			throw new IllegalArgumentException("Incorrect sort parameter");
		}
		try {
			Arrays.sort(this.student);
		} catch (NullPointerException e) {

		}
		try {
			for (int i = 0; i < student.length; i++) {
				System.out.println(student[i].toString());
			}
		} catch (NullPointerException e) {

		}
	}

	public void deleteStudent(Student student) {
		for (int i = 0; i < this.student.length; i++) {
			if (student == this.student[i]) {
				if (i < (this.student.length - 1)) {
					for (int j = i; j < (this.student.length - 1); j++) {
						this.student[j] = this.student[j + 1];
					}
				} else {
					this.student[i] = null;
				}
				this.index--;
			}
		}
	}

	public Student[] findStudent(String secondName) {
		Student tempArrayStudent[] = new Student[10];
		int j = 0;
		for (int i = 0; i < student.length; i++) {
			try {
				if (secondName.equalsIgnoreCase(student[i].getSecondName())) {
					tempArrayStudent[j] = this.student[i];
					j++;
				}
			} catch (NullPointerException e) {
			}
		}

		Student findArrayStudent[] = new Student[j];

		for (int i = 0; i < findArrayStudent.length; i++) {
			findArrayStudent[i] = tempArrayStudent[i];
		}
		return findArrayStudent;
	}

	public boolean checkStudentInGroup(Student student) {
		boolean checkStudent = true;
		for (int i = 0; i < this.student.length; i++) {
			try {
				if ((student.getSecondName().equalsIgnoreCase(this.student[i].getSecondName()))
						&& (student.getFirstName().equalsIgnoreCase(this.student[i].getFirstName()))
						&& (student.getAge() == this.student[i].getAge())) {
					checkStudent = false;
				}
			} catch (NullPointerException e) {

			}
		}
		return checkStudent;
	}

	public Student[] warriorStudent() {
		Student[] arrayWarriorTemp = new Student[10];
		int k = 0;
		try {
			for (int i = 0; i < arrayWarriorTemp.length; i++) {

				if (this.student[i].checkWarrior()) {
					arrayWarriorTemp[k] = this.student[i];
					k++;
				}
			}
		} catch (NullPointerException e) {
		}
		Student[] arrayWarrior = new Student[k];

		for (int j = 0; j < arrayWarrior.length; j++) {
			arrayWarrior[j] = arrayWarriorTemp[j];
		}

		return arrayWarrior;
	}

	@Override
	public String toString() {
		String infoGroup = nameOfGroup + ": ";
		Student.setSortParameter(1);
		try {
			Arrays.sort(this.student);
		} catch (NullPointerException e) {
		}
		try {
			for (int i = 0; i < student.length; i++) {
				infoGroup = infoGroup + this.student[i].toString() + "\n";
			}
		} catch (NullPointerException e) {
		}
		return infoGroup;
	}

	public String getNameOfGroup() {
		return nameOfGroup;
	}

	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}

	public Student[] getStudent() {
		return student;
	}

	public int getIndex() {
		return index;
	}

	// to lesson 5:

	public void setGroupOutFile() {
		File groupFile = new File(".//Group_" + this.nameOfGroup + ".txt");
		try (BufferedWriter bfWr = new BufferedWriter(new FileWriter(groupFile))) {
			if (!groupFile.exists()) {
				if (!groupFile.createNewFile()) {
					throw new IllegalArgumentException("Null file pointer");
				}
			}

			for (int i = 0; i < student.length; i++) {
				bfWr.write(student[i].toString());
				bfWr.newLine();
			}
		} catch (NullPointerException e) {

		} catch (IOException e) {
			System.out.println(e);
		} catch (SecurityException e) {
			System.out.println(e);
		}
	}

	public static Group getGroupFromFile(File groupFile) {
		if (!groupFile.exists()) {
			throw new IllegalArgumentException("Null file pointer");
		}

		String strTemp = groupFile.getName();
		Group group = new Group(strTemp.substring((strTemp.indexOf("_") + 1), (strTemp.indexOf("."))));

		try (BufferedReader bfRead = new BufferedReader(new FileReader(groupFile))) {

			while ((strTemp = bfRead.readLine()) != null) {

				group.addStudent(addStudentFromFile(strTemp));
				if (group.getIndex() > 10) {
					throw new FullGroupException();
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (FullGroupException e) {
			System.out.println(e);
		}
		return group;
	}

	public static Student addStudentFromFile(String toStringStudent) {
		int indexStrLow;
		int indexStrHight = 0;
		Student studentTemp = null;
		try {
			String[] strTempArray = new String[5];
			for (int i = 0; i < strTempArray.length; i++) {
				indexStrLow = toStringStudent.indexOf("=", indexStrHight) + 1;
				indexStrHight = toStringStudent.indexOf(",", (indexStrHight + 1));
				strTempArray[i] = toStringStudent.substring(indexStrLow, indexStrHight);
			}
			studentTemp = new Student();
			studentTemp.setFirstName(strTempArray[0]);
			studentTemp.setSecondName(strTempArray[1]);
			studentTemp.setAge(Integer.parseInt(strTempArray[2]));
			studentTemp.setSex(strTempArray[3]);
			studentTemp.setAvarageScore(Double.parseDouble(strTempArray[4]));

			indexStrLow = 0;
			indexStrHight = 0;

		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		return studentTemp;
	}
}
