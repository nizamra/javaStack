import java.lang.Math;

public class CHEATS {
    
public static double calculateHypotenuse(int legA, int legB) {
    double legC = (Math.pow(legA,2)+Math.pow(legB,2));
    double squareRoot = Math.sqrt(legC);
    return squareRoot;
}

public static void main(String[] args) {
    double flag = calculateHypotenuse(3,4);
    System.out.println(flag);
    System.out.println("My name is foo");
}

public static void vars(){
int ourInt; // we can declare a variable without setting its value
ourInt = 400; // we can assign a value to the variable later in our code
double pi = 3.14159265; // we can also declare and assign on the same line
boolean bool = true;
char singleCharacter = 'A';
String multipleCharacters = "ABC";
double d = 35.25;
double dd = 35.99;
// casting the double d into a int
int i = (int) d;
// casting the double dd into a int
int ii = (int) dd;
System.out.println(i);
System.out.println(ii);

int i = 35;
float f = i;
System.out.println("The number is: " + f);

// byte 1 byte -128 to 127
// short 2 bytes -32,768 to 32,767

// int: An int holds integers, like 4 or -51. It is limited to numbers between -2147483648 and 2147483647, or around 2 billion.
// long: These are for larger integers up to 2^63, or around 2 quintillion.
// boolean: A boolean represents one of two values: true or false.
// double: Doubles are for floating point numbers like 3.14159265. We will use double rather than float almost exclusively,
// because they are far more precise.
// char: The char data type is used to store a single character, like '$' or 'A'.

// Integer: The Integer class wraps a value of the primitive type int into an object.
// Long : The Long class wraps a value of the primitive type long in an object.
// Boolean: The Boolean class wraps a value of the primitive type boolean in an object.
// Double: The Double class wraps a value of the primitive type double in an object.
// Character: The Character class wraps a value of the primitive type char in an object.
// String: Represents a sequence of characters, like a Python string.
// BigInteger: Represents an integer that can be any size at all.

}

}

public static void main(String[] args) {
long start = System.currentTimeMillis();
Integer sum = 0;
for (int i = 0; i < Integer.MAX_VALUE; i++) {
sum += i;
}
System.out.println("Sum: " + sum);
long end = System.currentTimeMillis();
double total = (double) (end - start) / 1000;
System.out.println("Time of execution: " + total + " seconds");
}

public static void main(String[] args) {
long start = System.currentTimeMillis();
int sum = 0;
for (int i = 0; i < Integer.MAX_VALUE; i++) {
sum += i;
}
System.out.println("Sum: " + sum);
long end = System.currentTimeMillis();
double total = (double) (end - start) / 1000;
System.out.println("Time of execution: " + total + " seconds");
}


Integer a = 10;
int b = 10;
a = null;
b = null; //incompatible types: <null> cannot be converted to int

public class StringDemo {
public static void main(String[] args) {
String ninja = "Coding Dojo is Awesome!";
int length = ninja.length();
System.out.println( "String Length is : " + length );

String string1 = "My name is ";
String string2 = "Michael";
String string3 = string1.concat(string2);
System.out.println(string3);
System.out.println("Welcome," + " ninja" + "!";);

String nine = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
System.out.println(nine);


String ninja = "Welcome to Coding Dojo!";
int a = ninja.indexOf("Coding"); // a is 11
int b = ninja.indexOf("co"); // b is 3
int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found


String sentence = "       spaces everywhere!         ";
System.out.println(sentence.trim()) //removes any trailing or leading white spaces from the string.


String a = "HELLO";
String b = "world";
System.out.println(a.toLowerCase()); // hello
System.out.println(b.toUpperCase()); // WORLD



String a = new String("word");
String b = new String("word");
System.out.println(a == b); // false. not the same exact object.
System.out.println(a.equals(b)); // true. same exact characters.

public String concatSubstring(String foo, int x, int y, String bar){
        String result = foo.substring(x,y);
        return result.concat(bar);
    }
String word2 = manipulator.concatSubstring("Hello", 1, 2, "world");
System.out.println(word2); // eworld



boolean defenderGuarding = true;
boolean closeToBasket = true;
if(defenderGuarding == true) {
System.out.println("Pass The Ball");
} else if(closeToBasket == true) {
System.out.println("Shoot The Ball");
} else {
System.out.println("Dribble The Ball");
}


int[] myArray;
myArray = new int[5]; // Initialization
myArray[0] = 4;
myArray[1] = 8;
myArray[2] = 8;
myArray[3] = 5;
myArray[4] = 9;

int[] myArray = {4, 8, 8, 5, 9};


import java.util.ArrayList;
ArrayList<Integer> myArray = new ArrayList<Integer>();
myArray.add(10);
int num = myArray.get(0);


ArrayList<Object> list = new ArrayList<Object>();
list.add(10);
list.add("Hello");
list.add(new ArrayList<Integer>());
list.add(new Double(12.0)); // adding a Double of value 12.0
System.out.println(list); // [10, "Hello", [], 12.0]



int i = 0;
while(i < 7)
{
System.out.println("foo");
i++;
}



for (int i = 0; i < 7; i++){
System.out.println("bar");
}


for(int i = 0; i < dynamicArray.size(); i++){
String name = dynamicArray.get(i);
System.out.println("hello " + name);
// other operations using name
}


for(String name : dynamicArray){
System.out.println("hello " + name);
// other operations using name
}
for(element container : collection){
// body statements
}
// For the collection, just know that it will work with Arrays and ArrayLists for now, and as you progress you will see more and more
// uses for collection.


}
}