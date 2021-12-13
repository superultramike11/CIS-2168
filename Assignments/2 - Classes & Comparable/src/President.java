public class President  { 
    String name;
    int year;

    public President(String firstName, int yearElected) {
        name = firstName;
        year = yearElected;
    }

    public String toString() {
        return name;
    }
    
    public int getYear() {
    	return year;
    }
}
