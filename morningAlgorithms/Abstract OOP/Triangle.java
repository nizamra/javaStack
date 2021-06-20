
public class Triangle extends Shape {
	private int base;
	private int height;
	
	public Triangle() {
		
	}
	
	public Triangle(int base, int height,String color) {
		super();
		this.base = base;
		this.height = height;
		setColor(color);
	}

	@Override
	public double getArea() {
		return 0.5 * height * base;
	}

	@Override
	public String toString() {
		return "base: " + base + " height: " + height + " color: " + getColor();
	}
	
	
	
	
}
