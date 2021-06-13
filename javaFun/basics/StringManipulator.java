public class StringManipulator{
    public String trimAndConcat(String foo, String bar){
        return foo.trim().concat(bar.trim());
    }
    public Integer getIndexOrNull(String foo, char bar){
        Integer result = foo.indexOf(bar);
        if (result==-1){
            result = null;
        }
        return result;
    }
    public Integer getIndexOrNull(String foo, String bar){
        Integer result = foo.indexOf(bar);
        if (result==-1){
            result = null;
        }
        return result;
    }
    public String concatSubstring(String foo, int x, int y, String bar){
        String result = foo.substring(x,y);
        return result.concat(bar);
    }
}