package com.gmail.vsyniakin.triangle;

public class Main {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle(2, 3, 4);
		Triangle triangle2 = new Triangle(3, 5, 4);
		Triangle triangle3 = new Triangle(2, 2, 4);
		
		System.out.println(triangle1.areaTriangle());
		System.out.println(triangle2.areaTriangle());
		System.out.println(triangle3.areaTriangle());
	}

}
