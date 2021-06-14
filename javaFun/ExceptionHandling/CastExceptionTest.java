import java.util.ArrayList;

class CastExceptionTest{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World"); 

        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("something done right!");
            } catch (Exception e){
                System.out.println("Hey, uh, so, somethign bad happind..");
                System.out.println(i);
                System.out.println(myList.get(i));
            }
        }
    }
}