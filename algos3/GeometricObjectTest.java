import java.util.ArrayList;
public class GeometricObjectTest {

	public static void main(String[] args) {
		ArrayList<GeometricObject> myArr = new ArrayList<GeometricObject>();
		myArr.add(new Circle(4.66,"Blue", true));
		myArr.add(new Circle(13.46,"Black", false));
		myArr.add(new Rectangle(7, 2.8,"Red", true));
		myArr.add(new Rectangle(3.2, 6,"Maroon", true));
		
		System.out.println(myArr);
	}

}
