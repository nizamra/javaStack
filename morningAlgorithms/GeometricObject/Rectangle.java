import java.util.Date;

public class Rectangle extends GeometricObject {
	double width;
	double height;
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public Rectangle() {
		
	}
	public Rectangle(double width, double height,String color1, boolean filled1) {
		super();
		this.width = width;
		this.height = height;
		color = color1;
		filled = filled1;
		dateCreated= new Date();
		
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return (width * height);
	}
	public double getParameter() {
		return 2*(width+height);
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + " Area =" +getArea() +" parameter =" +getParameter() +" color =" +color+" filled=" +filled +" Date=" + getDate() + "]";
	}
	
}