package com.gmail.vsyniakin.cat;

public class Main {

	public static void main(String[] args) {
		Cat catVasya = new Cat("Pers", "Vasya", 9, 10.5);
		Cat catJony = new Cat("Scottish","Johnnie Walker", 6, 5.0);
		
		catVasya.getCatAction("Sleep & eat");
		catJony.getCatAction("Play & drink");
		
		System.out.println(catJony.toString());
		System.out.println(catVasya.toString());
		

	}

}
