package com.gmail.vsyniakin;

public class Table {
	private Shape [] shapeArgs = new Shape [4];
		
	public void putShape(Shape shape, int i) {
		if ((shapeArgs[i]==null) && (i>=0) && (i<4)) {
			shapeArgs[i] = shape;
		} else if ((i>=0) && (i<4)) {
			System.out.println("Sector " + i + " full!");		 
		} else {
			System.out.println("Sector no found!");
		} 
	}
	
	public void deleteShape(int i) {
		if ((shapeArgs[i]!=null) && (i>=0) && (i<4)) {
			shapeArgs[i] = null;
		} else if ((i>=0) && (i<4)) {
			System.out.println("Sector is empty.");		 
		} else {
			System.out.println("Sector no found!");
		}		
	}

	public String getInfoOfShapeOnTable() {
		String infoOfShape = "";
		double allArea = 0;
		for (int i = 0; i < shapeArgs.length; i++) {
			if (shapeArgs[i] != null) {
				infoOfShape = infoOfShape + "Sector # " + i + ": "+ shapeArgs[i].toString() + "\n";
				allArea = allArea + shapeArgs[i].getArea(); 
			}
		}
		infoOfShape = infoOfShape + "Area of all shape: " + allArea;
		return infoOfShape;
	}

}