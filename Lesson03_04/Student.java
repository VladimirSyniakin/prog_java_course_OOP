package com.gmail.vsyniakin;

public class Student extends Human implements Comparable, Warrior {

	private int age;
	private String sex;
	private double avarageScore;
	private static int sortParameter;

	public Student(String firstName, String secondName, int age, String sex, double avarageScore) {
		super(firstName, secondName);
		if (age < 0) {
			throw new IllegalArgumentException("Age < 0");
		}
		if ((avarageScore < 0.0) && (avarageScore > 5.0)) {
			throw new IllegalArgumentException("Not correct parameter: avarage score");
		}
		this.age = age;
		this.sex = sex;
		this.avarageScore = avarageScore;
	}

	public Student() {
		super();
	}

	@Override
	public boolean checkWarrior() {
		if ((this.age > 18) && (this.sex.equalsIgnoreCase("male"))) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		Student studentSort = (Student) o;

		if (sortParameter == 0) {
			return this.getFirstName().compareTo(studentSort.getFirstName());
		}
		if (sortParameter == 1) {
			return this.getSecondName().compareTo(studentSort.getSecondName());
		}
		if (sortParameter == 2) {
			if (this.age > studentSort.getAge()) {
				return +1;
			} else if (this.age < studentSort.getAge()) {
				return -1;
			} else {
				return 0;
			}
		}
		if (sortParameter == 3) {
			if (this.avarageScore > studentSort.getAvarageScore()) {
				return +1;
			} else if (this.avarageScore < studentSort.getAvarageScore()) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + getFirstName() + ", secondName=" + getSecondName() +  ", age=" + age + ", sex=" + sex + ", avarageScore=" + avarageScore + ",]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		if (age < 0) {
			throw new IllegalArgumentException("Age < 0");
		}
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getAvarageScore() {
		return avarageScore;
	}

	public void setAvarageScore(double avarageScore) {
		this.avarageScore = avarageScore;
		if ((avarageScore < 0.0) || (avarageScore > 5.0)) {
			throw new IllegalArgumentException("Not correct parameter: avarage score");
		}
	}

	public static int getSortParameter() {
		return sortParameter;
	}

	public static void setSortParameter(int sortParameter) {
		Student.sortParameter = sortParameter;
	}

}
