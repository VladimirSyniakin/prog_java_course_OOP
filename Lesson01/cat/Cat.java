package com.gmail.vsyniakin.cat;

public class Cat {
	
	private String breedCat;
	private String catName;
	private int age;
	private double weight;
	
	public Cat(String breedCat, String catName, int age, double weight) {
		super();
		this.breedCat = breedCat;
		this.catName = catName;
		this.age = age;
		this.weight = weight;
	}
	
	public Cat() {
		super();
	}

	public static String say() {
		return "Mia-mia";
	}
	
	public void getCatAction(String catAction) {
		System.out.println("catName= " + catName + ", catAction=" + catAction);
	}

	@Override
	public String toString() {
		return "Cat [breedCat=" + breedCat + ", age=" + age + ", weight=" + weight + ", say=" +  Cat.say() +  "]";
	}

	public String getBreedCat() {
		return breedCat;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public void setBreedCat(String breedCat) {
		this.breedCat = breedCat;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	

}
