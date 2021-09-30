import java.util.Comparator;

public class YearSort implements Comparator<President>{ //change this line
	@Override
	public int compare(President p1, President p2) {
		if(p1.getYear() > p2.getYear()) {
			return 1;
		}
		if(p1.getYear() < p2.getYear()) {
			return -1;
		}
		if(p1.getYear() == p2.getYear()) {
			return 0;
		}
		//return p1.getYear().compareTo(p2.getYear());
		return 0;
	}
}
