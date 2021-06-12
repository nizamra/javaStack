public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator manipulate = new StringManipulator();
        String finalResult = manipulate.trimAndConcat("  Hello   ","    World    ");
        System.out.println(finalResult);
        Integer trimFinal = manipulate.getIndexOrNull("Hello", 'z');
        System.out.println(trimFinal);
        Integer trimFinalString = manipulate.getIndexOrNull("Hello", "llo");
        System.out.println(trimFinalString);
        String finalSubString = manipulate.getConcatSubstring("Hello",1,2, "world");
        System.out.println(finalSubString);
    }

}
