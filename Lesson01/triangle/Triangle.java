package com.gmail.vsyniakin.triangle;

public class Triangle {
	private int a;
	private int b;
	private int c;
	
	public Triangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangle() {
		super();
	}
	
	public double areaTriangle () {
		double area = 0;
		if (checkTriangle()) {
			area = Math.sqrt(((a+b+c)*(b+c-a)*(a+c-b)*(a+b-c)))/4;	// ������� ������
		} 
		return area;
	}
	
	public boolean checkTriangle () {
		if (((a+b)>c)&&((a+c)>b)&&((c+b)>a)) {
			return true;
		} else {
			System.out.println("This is no triangle!");
			return false; 
		}
	}
		
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
}
