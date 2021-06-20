
public class ShapeTest {

	public static void main(String[] args) {
		//Shape firstShape = new Shape("black"); //NAH WE CANT
		Shape triangleOne = new Triangle(5,10,"black");
		System.out.println(triangleOne.getArea());
		System.out.println(triangleOne.toString());
	}

}
