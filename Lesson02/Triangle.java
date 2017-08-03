package com.gmail.vsyniakin;

public class Triangle extends Shape {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private double sideA;
	private double sideB;
	private double sideC;
	private double perimentr;
	private boolean check;
	
	public Triangle() {
		super();
		name = "Triangle";
	}

	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		name = "Triangle";
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		getSideTriangle();
		check = checkShape();
	}
	
	public void getSideTriangle() {
		sideA = sizeLine(pointB, pointC);
		sideB = sizeLine(pointA, pointC);
		sideC = sizeLine(pointA, pointB);
	}
	
	@Override
	public boolean checkShape () {
		if (((sideA + sideB) > sideC)&&((sideA + sideC) > sideB)&&((sideC + sideB) > sideA)) {
			return true;
		} else {
			System.out.println("This is no triangle!");
			return false; 
		}
	}
	
	@Override
	public double getPerimentr() {
		if (check) {
			perimentr = sideA + sideB + sideC; 
			return perimentr;
		} else {
			return 0;
		}
	}

	@Override
	public double getArea() {
		if (check){
			if (perimentr == 0) {
				getPerimentr();
				return Math.sqrt(((perimentr/2)*(perimentr/2-sideA)*(perimentr/2-sideB)*(perimentr/2-sideC)));
			} else {
				return Math.sqrt(((perimentr/2)*(perimentr/2-sideA)*(perimentr/2-sideB)*(perimentr/2-sideC)));
			}
		} else {
			return 0;
		}
	}
	
	


	@Override
	public String toString() {
		return super.toString() + "[pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", check=" + check + ", Perimentr=" + getPerimentr() +", Area=" + getArea() + "]";
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public boolean isCheck() {
		return check;
	}
}
