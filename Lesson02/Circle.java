package com.gmail.vsyniakin;

public class Circle extends Shape {

	private Point pointCenter;
	private Point pointOnCircle;
	private double radius;
	
	public Circle(Point pointCenter, double radius) {
		super();
		name = "Circle";
		this.pointCenter = pointCenter;
		this.radius = radius;
	}

	public Circle(Point pointCenter, Point pointOnCircle) {
		super();
		name = "Circle";
		this.pointCenter = pointCenter;
		this.pointOnCircle = pointOnCircle;
		radius = sizeLine(pointCenter, pointOnCircle);
	}

	public Circle() {
		super();
		name = "Circle";
	}
	
	@Override
	public boolean checkShape () {
		if (radius > 0) {
			return true;
		} else {
			System.out.println("This is no circle!");
			return false; 
		}
	}
	
	@Override
	public double getPerimentr() {
		return (2*Math.PI*radius);
	}

	@Override
	public double getArea() {
		return (Math.PI*radius*radius);
	}
	
		@Override
	public String toString() {
		return super.toString() + "[pointCenter=" + pointCenter + ", radius=" + radius + ", check=" + checkShape() + ", Perimentr=" + getPerimentr() +", Area=" + getArea() +"]";
	}

	public Point getPointCenter() {
		return pointCenter;
	}

	public void setPointCenter(Point pointCenter) {
		this.pointCenter = pointCenter;
	}

	public Point getPointOnCircle() {
		return pointOnCircle;
	}

	public void setPointOnCircle(Point pointOnCircle) {
		this.pointOnCircle = pointOnCircle;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}