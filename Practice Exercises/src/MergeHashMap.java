import java.util.HashMap;

public class MergeHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> h1 = new HashMap<String, Integer>();
        h1.put("aiko", 2);
        h1.put("fluffy", 5);
        h1.put("zugzwang", 10);

        HashMap<String, Integer> h2 = new HashMap<String, Integer>();
        h2.put("fluffy", 1);
        h2.put("aiko", 5);
        h2.put("panda", 2222);

        HashMap<String, Integer> h3 = new HashMap<String, Integer>();

        h3.putAll(h1);
        h3.putAll(h2);

        System.out.println(h3);
    }
}
