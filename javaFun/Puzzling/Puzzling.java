import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Puzzling {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(7);
        numbers.add(9);
        numbers.add(8);
        numbers.add(13);
        numbers.add(25);
        numbers.add(32);
        ArrayList<Integer> numbers3 = sumGreater(numbers);
        System.out.println(numbers3);
        ////////////////////////////////////////////////////////////
        ArrayList<String> namess = new ArrayList<String>();
        namess.add("Nancy");
        namess.add("Jinichi");
        namess.add("Fujibayashi");
        namess.add("Momochi");
        namess.add("Ishikawa");
        ArrayList<Integer> namesss = namessGreater(namess);
        System.out.println(namesss);
        ////////////////////////////////////////////////////////////
        ArrayList<Character> letters = new ArrayList<Character>();
        for (byte i = 97; i<122 ; i++){
            letters.add((char)i);
        }
        displayLetter(letters);
        ////////////////////////////////////////////////////////////
        ArrayList<Integer> randomNums = new ArrayList<Integer>();
        Random r = new Random();
        for (byte i = 0; i<10 ; i++){
            randomNums.add(r.nextInt(45) + 55);
        }
        System.out.println("Random Numbers: " + randomNums);
        int maximum = randomNums.get(0);
        int minimum = randomNums.get(0);
        for (int i : randomNums){
            if (maximum < i) {
                maximum = i;
            }
            if (minimum > i) {
                minimum = i;
            }
        }
        System.out.println("Random Numbers maximum: " + maximum);
        System.out.println("Random Numbers minimum: " + minimum);


        String charsOfOmar = "";
        for (byte i = 0; i<5 ; i++){
            // int x = r.nextInt(122-97) + 97;
            charsOfOmar += letters.get(r.nextInt(25));
        }
        System.out.println("charsOfOmar: " + charsOfOmar);



        // array with 10 random strings that are each 5 characters long
        ArrayList<String> omarsArr = new ArrayList<String>();
        for (byte i = 0; i<10 ; i++){
            String omarStr = "";
            for (byte j = 0; j<5 ; j++){
            omarStr += letters.get(r.nextInt(25));
        }
        omarsArr.add(omarStr);
        }
        System.out.println("omarsArr: " + omarsArr);
        // Collections.shuffle(numbers);
        // System.out.println(numbers); // [1, 5, 2, 4, 3]
        // Collections.sort(numbers);
        // System.out.println(numbers); // [1, 2, 3, 4, 5]
                
        // Random r = new Random();
        // System.out.println(r.nextInt()); // without bounds
        // System.out.println(r.nextInt(5)); // with bounds 0 to 5
    }

    public static ArrayList sumGreater(ArrayList<Integer> x){
        byte sum = 0;
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        for (int i : x){
            sum+=i;
            if (i>10){
                numbers2.add(i);
            }
        }
        System.out.println("Sum: " + sum);
        return numbers2;
    }

    public static ArrayList namessGreater(ArrayList<String> x){
        ArrayList<String> namesBack = new ArrayList<String>();
        Collections.shuffle(x);
        for (String i : x){
            System.out.println(i);
            if (i.length()>5){
                namesBack.add(i);
            }
        }
        return namesBack;
    }

    public static void displayLetter(ArrayList<Character> x){
        Collections.shuffle(x);
        Object[] y= x.toArray();
        System.out.println(y[0]);
        System.out.println(y[y.length-1]);
        Character[] vowel = {'a', 'e' ,'i', 'o', 'u'};
        if (Arrays.asList(vowel).contains(y[0])){
            System.out.println("The first letter is a vowel");
        }
    }
}




// To get a random integer, you can use the nextInt method of the Random class. Random Class documentation
//  Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest
// number in the beginning).
// Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.


//  Create a random string that is 5 characters long.

//  Generate an array with 10 random strings that are each 5 characters long