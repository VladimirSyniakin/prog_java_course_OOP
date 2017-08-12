package com.gmail.vsyniakin.task1;

import java.io.Serializable;

public class Group implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameGroup;
	private Student[] students = new Student[10];
	private int index;

	public Group(String nameGroup) {
		super();
		this.nameGroup = nameGroup;
	}

	public Group() {
		super();
	}

	public void addStudent(Student student) {
		boolean checkStudent = true;
		if (student.getFirstName() == null || student.getSecondName() == null || student.getAge() == 0) {
			throw new NullPointerException();
		}
		for (int i = 0; i < students.length; i++) {
			try {
				if (student.equals(students[i])) {
					checkStudent = false;
					System.out.println(student.toString() + "This student is already in the group.");
				}
			} catch (NullPointerException e) {

			}
		}
		try {
			if (checkStudent) {
				students[index] = student;
				index++;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Group is full!");
		}
	}

	public void deleteStudent(Student student) {
		int i = 0;
		try {
			boolean findStudent = false;
			for (i = 0; i < students.length; i++) {
				if (student.equals(students[i]) && !findStudent) {
					findStudent = true;
					index--;
				}
				if (findStudent) {
					students[i] = students[i + 1];
				}
			}
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			students[i] = null;
		}
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		String group = nameGroup + "\n";
		try {
			for (int i = 0; i < students.length; i++) {
				group = group + students[i].toString() + "\n";
			}
		} catch (NullPointerException e) {

		}
		return group;
	}
}
