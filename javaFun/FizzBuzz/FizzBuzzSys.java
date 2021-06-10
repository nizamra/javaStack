import java.lang.Math;

public class FizzBuzzSys {
	
public static void printBuzz(int alpha) {
	if(alpha % 5 == 0 && alpha % 3 == 0){
	    System.out.println("FizzBuzz");
	} else if(alpha % 3 == 0) {
	    System.out.println("Fizz");
	} else if (alpha % 5 == 0){
	    System.out.println("Buzz");
	}else {
	    System.out.println(alpha);
	}
}

public static void main(String[] args) {
	printBuzz(15);
}
}