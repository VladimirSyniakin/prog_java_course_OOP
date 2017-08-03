package com.gmail.vsyniakin.vector3d;

public class Vector3d {
	
	private int x;
	private int y;
	private int z;
	
	public Vector3d(int x,int y,int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector3d() {
		super();
	}
	
	@Override
	public String toString() {
		return "Vector3d [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	public static Vector3d sumVector (Vector3d a, Vector3d b) {
		Vector3d c = new Vector3d(a.x+b.x, a.y+b.y, a.z+b.z);
		return c;
	}
	
	public static Vector3d scalarMultiplication (Vector3d a, Vector3d b) {
		Vector3d c = new Vector3d(a.x*b.x, a.y*b.y, a.z*b.z);
		return c;
	}
	
	public static Vector3d vectorMultiplication (Vector3d a, Vector3d b) {
		Vector3d c = new Vector3d((a.y*b.z - a.z*b.y), (a.z*b.x - a.x*b.z), (a.x*b.y-a.y*b.x));
		return c;
	}
		
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
