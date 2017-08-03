package com.gmail.vsyniakin;

public class Main {

	public static void main(String[] args) {
		
		Triangle shape01 = new Triangle(new Point(0, 0), new Point(3, 3), new Point(1,5));
		System.out.println(shape01.getPerimentr());
		System.out.println(shape01.getArea());
		
		Circle shape02 = new Circle(new Point(0, 0), new Point(0, 7));
		System.out.println(shape02.getPerimentr());
		System.out.println(shape02.getArea());
		
		Circle shape03 = new Circle(new Point(2, 2), 7.0);
		System.out.println(shape03.getPerimentr());
		System.out.println(shape03.getArea());
		
		Quadrilateral shape04 = new Quadrilateral(new Point(7, 3), new Point(2, 8), new Point(1, 1), new Point(4, -5));

		System.out.println(shape04.getPerimentr());
		System.out.println(shape04.getArea());
		
		Rectangle shape05 = new Rectangle(new Point(2, 2), new Point(2, 8), new Point(12, 2), new Point(12, 8));

		System.out.println(shape05.getPerimentr());
		System.out.println(shape05.getArea());
		
		Table myTable = new Table();
		
		myTable.putShape(shape05, 0);
		myTable.putShape(shape03, 1);
		myTable.putShape(shape01, 2);
		myTable.putShape(shape04, 3);
		myTable.deleteShape(1);
		System.out.println(myTable.getInfoOfShapeOnTable());

	}

}