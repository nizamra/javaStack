import java.lang.Math;

public class pythagoreanTheorem {
	public static void main(String[] args) {
		double flag = calculateHypotenuse(6,8);
		System.out.println(flag);
	}
		
	public static double calculateHypotenuse(int legA, int legB) {
		double legC = (Math.pow(legA,2)+Math.pow(legB,2));
		double squareRoot = Math.sqrt(legC);
		return squareRoot;
	}


}