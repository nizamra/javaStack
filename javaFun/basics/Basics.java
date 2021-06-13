import java.lang.Math;
import java.util.*;

public class Basics {
	
public void printNums(int x) {
	for (int i=0; i<= x; i++) {
	System.out.println(i);
	}
}

public void printOdd(int x) {
	for (int i=1; i<= x; i++) {
		System.out.println(i);
		i++;
	}
}

public void printSum(int x) {
	int sum = 0;
	for (int i=0; i<= x; i++) {
	sum = sum +i;
	System.out.println("New number: " +i+ "  Sum: " +sum);
	}
}

public void printArr(int[] x) {
	for (int i : x) {
	System.out.println(i);
	}
}

public void findMax(int[] x) {
	int max = x[0];
	for (int i : x) {
		if (max < i) {
			max = i;
		}
	}
	System.out.println(max);
}

public void getAverage(int[] x) {
	int sum = 0;
	for (int i : x) {
		sum = sum +i;
	}
	System.out.println(sum/x.length);
}

public void arrayWithOdd(int x) {
	ArrayList<Integer> y = new ArrayList<Integer>();
	for (int i=1; i < x; i+=2) {
		y.add(i);
	}
	System.out.println(y);
}

public void greaterThan(int[] x, int y) {
	int sum =0;
	for (int i : x) {
		if (i>y) {
			sum++;
		}
	}
	System.out.println(sum);
}

public void squareValues(int[] x) {
	ArrayList<Integer> y = new ArrayList<Integer>();
	for (int i : x) {
		y.add(i*i);
	}
	System.out.println(y);
}

public void eliminateNegative(int[] x) {
	ArrayList<Integer> y = new ArrayList<Integer>();
	for (int i : x) {
		if (i>0) {
			y.add(i);
		}else {
			y.add(0);
		}
	}
	System.out.println(y);
}

public void maxMinAverage(int[] x) {
	int max = x[0];
	int sum = 0;
	int min = x[0];
	for (int i : x)  {
		sum = sum +i;
		if (max < i) {
			max = i;
		}
		if (min > i) {
			min = i;
		}
	}
	System.out.println("AVG: "+ (float) sum/x.length);
	System.out.println("MAXNUM: "+max);
	System.out.println("MINNUM: "+ min);
}

public void shiftingValues(int[] x) {
	ArrayList<Integer> y = new ArrayList<Integer>();
	for (int i=1; i< x.length; i++)  {
		y.add(x[i]);
	}
	y.add(0);
	System.out.println(y);
}

}
