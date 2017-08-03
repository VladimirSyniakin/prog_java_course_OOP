package com.gmail.vsyniakin;

public class Rectangle extends Quadrilateral {
		
	public Rectangle() {
		name = "Rectangle";	
	}

	public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
		super(pointA, pointB, pointC, pointD);
		name = "Rectangle";
		getSideQuadrilateral();
		check = checkShape();
	}

	@Override
	public boolean checkShape() {
		super.checkShape();
		// проверка равности сторон и что квадрат сторон равен квадрату диагонали
		if (((int) (100 * getSideA()) == (int) (100 * getSideC()))&&((int) (100 * getSideB()) == (int) (100 * getSideD()))&&(Math.round(Math.pow(getDiagonal(), 2)) == Math.round(Math.pow(getSideA(), 2) + Math.pow(getSideB(), 2)))){
			return true;
		} else {
			System.out.println("This is no rectangle!");
			return false;
		}
	}

	@Override	
	public double getArea() {
		if (check) {
			return (getSideA()*getSideB());
		} else {
			return 0;
		}
		
	}

	@Override
	public String toString() {
		return super.toString() + ", Perimentr=" + getPerimentr() +", Area=" + getArea() + "]";
	}
}
