import java.util.Comparator; 
public class MovieInfo implements Comparable <MovieInfo> {
	String title;
	String genre;
	String leadActor;
	 
	MovieInfo(String t, String g, String a) {
		title = t; genre = g; leadActor = a;
	}
	 
	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}
	
	// getters
	public String getTitle() { return title; }
	public String getGenre( ) { return genre; }
	public String getActor( ) { return leadActor; }
	
	// Used to sort by title
	@Override
	public int compareTo(MovieInfo other) {
		return this.getTitle().compareTo(other.getTitle());
	}
	
	// Comparator. Used to sort movies by genre.
	public static class GenreOrder implements Comparator<MovieInfo> {
		@Override
		public int compare(MovieInfo movie1, MovieInfo movie2) {
			return movie1.getGenre().compareTo(movie2.getGenre());
		}
	}
	
	// Comparator. Used to sort movies by actor's name.
	public static class ActorOrder implements Comparator<MovieInfo> {
		@Override
		public int compare(MovieInfo movie1, MovieInfo movie2) {
			return movie1.getActor().compareTo(movie2.getActor());
		}
	}
}
