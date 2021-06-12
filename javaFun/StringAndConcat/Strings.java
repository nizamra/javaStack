public class Strings {
public static void main(String[] args) {
    System.out.println(trimAndConcat("    Hello     ","     World    "));
    System.out.println(getIndexOrNull("Hello",'r'));
    System.out.println(getIndexOrNull("Hello","lo"));
    System.out.println(concatSubstring("Hello",1,4," lala land"));
}

public static String trimAndConcat(String a, String b) {
    a.trim;
    b.trim;
return a.concat(b)}

public static Integer getIndexOrNull(String a, char b) {
    int cc = a.indexOf(b);
    if (cc == -1){cc = null;}
return cc}

public static Integer getIndexOrNull(String a, String b){
    int cc = a.indexOf(b);
    if (cc == -1){cc = null;}
return cc}
}

public static String concatSubstring(String a, int x, int y, String b) {
    String aa = a.substring(x,y)
return aa.concat(b)}

}