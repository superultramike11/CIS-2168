public class Puppy implements Comparable<Puppy> {
    private int id;

    public static void main(String[] args) {
        Puppy fluffy = new Puppy(); fluffy.id = 5;
        Puppy echo = new Puppy(); echo.id = 7;

        System.out.println(fluffy.compareTo(echo));
        System.out.println(fluffy.compareTo(fluffy));
        System.out.println(echo.compareTo(fluffy));
    }

    public int compareTo(Puppy p) { return id - p.id; }
}