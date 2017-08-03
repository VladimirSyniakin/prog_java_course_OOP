package com.gmail.vsyniakin;

// для просчета берутся только выпуклые 4-х угольники. 
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
	// сортитировка точек по оси X по возрастанию и перенос начала оси координат в минимальную точку по оси Х:
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
		
	// для простоты просчета, перенос начала оси координат в минимальную точку по оси Х:
		for (j = 1; j < pointQuadrilateral.length; j++) {
			pointQuadrilateral[j].setX((int) (pointQuadrilateral[j].getX()-pointQuadrilateral[0].getX())); // почему думает что должен быть (double)??
			pointQuadrilateral[j].setY((int) (pointQuadrilateral[j].getY()-pointQuadrilateral[0].getY()));
		}	
		pointQuadrilateral[0].setX(0);
		pointQuadrilateral[0].setY(0);
		pointA = pointQuadrilateral[0]; // присваиваем pointA значению точки отсчета 0;0.
	}
	
	/* подключаем тригонометрию так как массив отсортирован по оси X, все остальные точки перенесены относительно 1-й точки
	и находятся в + координатах по X - sin угла от начала координат к находится в пределах -1 и +1, 
	высчитав sin углов отрезков от минимальной точки мы определяем положение точки по середине. 
	Это значит две крайние точки - это стороны, а средняя будет диаганалью (от нулевой точки).
	sin - значение по оси Y, делим на длину стороны.	
	 */
	public void sinPoint () {
		
		pointSortToMinX();
		// создали три sin на наши отрезки и определение pointB и pointC:
		for (int i = 1; i < (pointQuadrilateral.length); i++) {
			sin[i-1] = pointQuadrilateral[i].getY()/sizeLine(pointQuadrilateral[0], pointQuadrilateral[i]);
		}
		
		/* так как отрезки от точки 0;0 до точки с мин и макс sin будут являться сторонами,
		 то sin точки между крайними положениями - будет диагональю четырехугольника и определим ее точкой pointD.
		 Так же если какие либо синусы равны - тогда 3 точки находятся на 1-й прямой и это уже не 4-х угольник.
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
	
	/* после определения положения точек - нужно определить положение точки pointD, относительно отрезка pointB к pointC, 
	если точка за отрезком - 4-х угольник выпуклый, если же перед, то четырехугольник является не выпуклый(является исключением).
	Для решение данной задачи используем - решение линейного уровнения y = ax + b, которое описывает отрезок между pointB и pointC,
	с дальнейшим подставлением координат точки pointD и определение ее местоположения.
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
		// следующая проверка на то, что бы точки не лежали на одной прямой между точками B и С
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

	// площадь выпуклого четырехугольника можно посчитать как площадь двух треугольников образованные диагональю:
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
