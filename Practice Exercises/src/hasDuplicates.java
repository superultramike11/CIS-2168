import java.util.*;

public class hasDuplicates {
    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{2,1,6,8,1});
        System.out.println(hasDuplicates(list));
    }
}
