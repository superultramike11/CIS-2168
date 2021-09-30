import java.io.*;
import java.util.*;

public class TestMovies {
	public static List<MovieInfo> movieList = new ArrayList<>();
	 
	public static void main(String[] args) {
		populateList();
		System.out.println(movieList); //output as read from file
		
		Collections.sort(movieList);
		System.out.println(movieList); //output as sorted by title
		
		Comparator<MovieInfo> gs = new MovieInfo.GenreOrder();
		Collections.sort(movieList, gs);
		System.out.println(movieList); //output as sorted by genre
		
		Comparator<MovieInfo> ac = new MovieInfo.ActorOrder();
		Collections.sort(movieList, ac);
		System.out.println(movieList);
	}
	
	public static void populateList() {
		// read the file, create MovieInfo instances, and
		// populate the ArrayList movieList with these instances
		try {
		Scanner sc = new Scanner(new File("movie.txt"));
		String line;
		String[] tokens;
		
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			tokens = line.split("/");
			movieList.add(new MovieInfo(tokens[0], tokens[1], tokens[2]));
		}
		} catch (FileNotFoundException e) { }
	}
}