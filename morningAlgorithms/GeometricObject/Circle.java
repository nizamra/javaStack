import java.util.Date;

public class Circle extends GeometricObject{
	double radius;
	public Circle() {
		
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(double radius,String color1, boolean filled1) {
		super();
		this.radius = radius;
		color = color1;
		filled = filled1;
		dateCreated= new Date();
	}
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return (radius * radius * 3.14);
	}
	public double getParameter() {
		return (2*radius* 3.14);
	}
	public double getDiameter() {
		return (2*radius);
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius +" Area =" +getArea() +" parameter =" +getParameter() +" Diameter =" +getDiameter() +" color =" +color+" filled=" +filled +" Date=" +dateCreated + "]";
	}
	
	
}