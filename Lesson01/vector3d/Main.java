package com.gmail.vsyniakin.vector3d;

public class Main {

	public static void main(String[] args) {
		
		Vector3d a1 = new Vector3d(3,2,5);
		Vector3d b1 = new Vector3d(4,7,2);
				
		Vector3d c1 = Vector3d.scalarMultiplication(a1, b1);

		System.out.println(c1);
				
		System.out.println(Vector3d.sumVector(a1, b1));
		
		System.out.println(Vector3d.vectorMultiplication(a1, b1));
		
		System.out.println(Vector3d.sumVector(new Vector3d(1, 2, 3), new Vector3d(2,1,5)));
	}
}
