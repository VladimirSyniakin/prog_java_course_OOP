package com.gmail.vsyniakin;

public abstract class Shape {
	
	protected String name;
	
	public Shape(String name) {
		super();
		this.name = name;
	}
		
	public Shape() {
		super();
	}


	public abstract double getPerimentr();
	
	public abstract double getArea();
	
	public abstract boolean checkShape();

	public double sizeLine(Point pointA, Point pointB) {
		double line = Math.hypot((pointA.getX()- pointB.getX()), (pointA.getY()- pointB.getY()));
		return line;
	}
	
	@Override
	public String toString() {
		return "Shape [name=" + name + "]";
	}

	public String getName() {
		return name;
	}
}
