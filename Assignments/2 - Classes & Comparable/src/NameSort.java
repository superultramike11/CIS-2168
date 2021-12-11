import java.util.Comparator;

public class NameSort implements Comparator<President>{ //change this line
	@Override
	public int compare(President p1, President p2) {
		return p1.toString().compareTo(p2.toString());
	}
}



