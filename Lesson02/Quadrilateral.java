package com.gmail.vsyniakin;

// ��� �������� ������� ������ �������� 4-� ���������. 
public class Quadrilateral extends Shape {
	
	private Point [] pointQuadrilateral = new Point [4] ;
	private Point pointA; 		
	private Point pointB;		
	private Point pointC;		
	private Point pointD;
	private double sideA;
	private double sideB;
	private double sideC;
	private double sideD;
	private double [] sin = new double [3];
	private double diagonal;
	protected boolean check;
	
	
		
	public Quadrilateral() {
		super();
		name = "Quadrilateral";
	}

	public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD) {
		super();
		
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
		name = "Quadrilateral";
		check = checkShape();
		getSideQuadrilateral();
	}
	// ������������ ����� �� ��� X �� ����������� � ������� ������ ��� ��������� � ����������� ����� �� ��� �:
	public void pointSortToMinX (){
		pointQuadrilateral [0] = pointA;
		pointQuadrilateral [1] = pointB;
		pointQuadrilateral [2] = pointC;
		pointQuadrilateral [3] = pointD;
		int j;
		Point pointTemp;
		for (int i = 1; i < pointQuadrilateral.length; i++) {
			pointTemp = pointQuadrilateral [i];
			j = i-1;
			while ((j >= 0) && (pointQuadrilateral[j].getX()>pointTemp.getX())) {
				pointQuadrilateral[j+1] = pointQuadrilateral[j];
				j = j - 1;
				
			}
			pointQuadrilateral[j+1] = pointTemp;
		}
		
	// ��� �������� ��������, ������� ������ ��� ��������� � ����������� ����� �� ��� �:
		for (j = 1; j < pointQuadrilateral.length; j++) {
			pointQuadrilateral[j].setX((int) (pointQuadrilateral[j].getX()-pointQuadrilateral[0].getX())); // ������ ������ ��� ������ ���� (double)??
			pointQuadrilateral[j].setY((int) (pointQuadrilateral[j].getY()-pointQuadrilateral[0].getY()));
		}	
		pointQuadrilateral[0].setX(0);
		pointQuadrilateral[0].setY(0);
		pointA = pointQuadrilateral[0]; // ����������� pointA �������� ����� ������� 0;0.
	}
	
	/* ���������� ������������� ��� ��� ������ ������������ �� ��� X, ��� ��������� ����� ���������� ������������ 1-� �����
	� ��������� � + ����������� �� X - sin ���� �� ������ ��������� � ��������� � �������� -1 � +1, 
	�������� sin ����� �������� �� ����������� ����� �� ���������� ��������� ����� �� ��������. 
	��� ������ ��� ������� ����� - ��� �������, � ������� ����� ���������� (�� ������� �����).
	sin - �������� �� ��� Y, ����� �� ����� �������.	
	 */
	public void sinPoint () {
		
		pointSortToMinX();
		// ������� ��� sin �� ���� ������� � ����������� pointB � pointC:
		for (int i = 1; i < (pointQuadrilateral.length); i++) {
			sin[i-1] = pointQuadrilateral[i].getY()/sizeLine(pointQuadrilateral[0], pointQuadrilateral[i]);
		}
		
		/* ��� ��� ������� �� ����� 0;0 �� ����� � ��� � ���� sin ����� �������� ���������,
		 �� sin ����� ����� �������� ����������� - ����� ���������� ���������������� � ��������� �� ������ pointD.
		 ��� �� ���� ����� ���� ������ ����� - ����� 3 ����� ��������� �� 1-� ������ � ��� ��� �� 4-� ��������.
		 */
		if ((sin[0]==sin[1])||(sin[0]==sin[2])||(sin[1]==sin[2])) {
			System.out.println("This is no quadrilateral!");
		} else if (((sin[1]<sin[0])&&(sin[0]<sin[2]))||((sin[1]>sin[0])&&(sin[0]>sin[2]))) {
			pointD = pointQuadrilateral[1];
			pointB = pointQuadrilateral[2];
			pointC = pointQuadrilateral[3];
		} else if (((sin[0]<sin[1])&&(sin[1]<sin[2]))||((sin[0]>sin[1])&&(sin[1]>sin[2]))) {
			pointD = pointQuadrilateral[2];
			pointB = pointQuadrilateral[1];
			pointC = pointQuadrilateral[3];
		} else if (((sin[0]<sin[2])&&(sin[2]<sin[1]))||((sin[0]>sin[2])&&(sin[2]>sin[1]))) {
			pointD = pointQuadrilateral[3];
			pointB = pointQuadrilateral[1];
			pointC = pointQuadrilateral[2];
		} 
	}
	
	/* ����� ����������� ��������� ����� - ����� ���������� ��������� ����� pointD, ������������ ������� pointB � pointC, 
	���� ����� �� �������� - 4-� �������� ��������, ���� �� �����, �� ��������������� �������� �� ��������(�������� �����������).
	��� ������� ������ ������ ���������� - ������� ��������� ��������� y = ax + b, ������� ��������� ������� ����� pointB � pointC,
	� ���������� ������������� ��������� ����� pointD � ����������� �� ��������������.
	*/
	@Override
	public boolean checkShape() {
		double a;
		double b;
		sinPoint();
		if (pointC.getX()-pointB.getX() != 0) {
			a = (pointC.getY()-pointB.getY())/(pointC.getX()-pointB.getX());
			b = pointB.getY() - (a * pointB.getX());
		} else {
			a = 0;
			b = 0;
		}
		// ��������� �������� �� ��, ��� �� ����� �� ������ �� ����� ������ ����� ������� B � �
		if ((pointD.getY() == (a*pointD.getX() + b))||(pointA.getY() == (a*pointA.getX() + b))) {
			System.out.println("This is no quadrilateral!");	
			return false; 			
		} else if ((a < 0)&&(pointD.getY()>(a*pointD.getX() + b))||(a > 0)&&(pointD.getY()<(a*pointD.getX() + b))) {
			return true;			
		} else {
			System.out.println("It is a concave quadrilaterals! The area is not possible to count.");
			return false;
		}
	}
	
	public void getSideQuadrilateral() {
			sideA = sizeLine(pointA, pointB);
			sideB = sizeLine(pointB, pointD);
			sideC = sizeLine(pointC, pointD);
			sideD = sizeLine(pointA, pointC);
			diagonal = sizeLine(pointA, pointD);
	}
	
	@Override
	public double getPerimentr() {
		if (check) {
			return (sideA + sideB + sideC + sideD);
		} else {
			return 0;
		}
	}

	// ������� ��������� ���������������� ����� ��������� ��� ������� ���� ������������� ������������ ����������:
	@Override
	public double getArea() {
		if (check) {
			double semiperimeterABD = (sideA + sideB + diagonal)/2;
			double semiperimeterACD = (sideC + sideD + diagonal)/2;
			double areaABD = Math.sqrt((semiperimeterABD)*(semiperimeterABD-sideA)*(semiperimeterABD-sideB)*(semiperimeterABD-diagonal));
			double areaACD = Math.sqrt((semiperimeterACD)*(semiperimeterACD-sideC)*(semiperimeterACD-sideD)*(semiperimeterACD-diagonal));
			return (areaABD + areaACD);
		} else {
			return 0;
		}
	}

	
	
	@Override
	public String toString() {
		return super.toString() + "[pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointD=" + pointD
				+ ", check=" + check + ", Perimentr=" + getPerimentr() +", Area=" + getArea() + "]";
	}

	public Point[] getPointQuadrilateral() {
		return pointQuadrilateral;
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
	public Point getPointD() {
		return pointD;
	}
	public void setPointD(Point pointD) {
		this.pointD = pointD;
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
	public double getSideD() {
		return sideD;
	}
	public double[] getSin() {
		return sin;
	}
	public double getDiagonal() {
		return diagonal;
	}
	public boolean isCheck() {
		return check;
	}
}
