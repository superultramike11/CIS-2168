import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        TreeSet<String> subs = new TreeSet<>();
        s.add("a"); s.add("b"); s.add("c"); s.add("d"); s.add("e");
        subs = (TreeSet) s.subSet("b", true, "d", true);
        System.out.println(subs);
        s.add("g");
        s.pollFirst();
        s.pollFirst();
        s.add("c2");
        System.out.println(s.size() + " " + subs.size());
        System.out.println(subs);
    }
}
