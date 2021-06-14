import java.util.HashMap;
import java.util.Set;

public class SongsHashMap {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("baly ma3ak", "baly ma3ak baly baly baly baly, yabo el3oyoun ghaly ghaly ghaly ghaly");
        trackList.put("ghouraba2", "na7n nabkiee wa nosalliee yawom ylhoo wa yoghanny el2a5rooon");
        trackList.put("essalam 3alykom", "es es essalam 3alaykom");
        trackList.put("o7ib yadayk", "w akthar akthar o7ib bilady");

        String Lyrics = trackList.get("baly ma3ak");
        System.out.println("Lyrics: " + Lyrics);
        System.out.println();

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));    
        }
    }
}