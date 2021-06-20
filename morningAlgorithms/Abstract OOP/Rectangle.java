public class Rectangle extends Shape {
	private int length;
	private int width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int length, int width,String color) {
		this.length = length;
		this.width = width;
		setColor(color);
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public String toString() {
		return "length: " + length + "width: " + width + "color: " + getColor();
	}
	
	
	
}
