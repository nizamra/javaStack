import java.util.Date;

public class Time {

    public String getCurrentDate() {
        Date date = new Date();
        return "Current date is: " + date;
        }
}


// public static void main(String[] args) {
// long start = System.currentTimeMillis();
// int sum = 0;
// for (int i = 0; i < Integer.MAX_VALUE; i++) {
// sum += i;
// }
// System.out.println("Sum: " + sum);
// long end = System.currentTimeMillis();
// double total = (double) (end - start) / 1000;
// System.out.println("Time of execution: " + total + " seconds");
// }