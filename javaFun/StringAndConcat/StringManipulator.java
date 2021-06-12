public class StringManipulator{
    public String trimAndConcat(String x , String y){
        String one = x.trim();
        String two = y.trim();
        String concat = one.concat(two);
        return concat;
    }
    public Integer getIndexOrNull(String x , char y){
        if (x.indexOf(y) != -1){
            return x.indexOf(y);
        } else {
            return null;
        }
    }
    public Integer getIndexOrNull(String x, String y){
        if (x.indexOf(y) != -1){
            return x.indexOf(y);
        } else {
            return null;
        }
    }
    public String getConcatSubstring(String x , int y , int d , String z){
        String sub = x.substring(y,d);
        return sub.concat(z);

    }
}