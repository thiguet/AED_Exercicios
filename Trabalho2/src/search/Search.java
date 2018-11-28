package search;
import java.util.List;

public interface Search {
	public boolean exists (String word);
	public void add(List<String> content);
	public void printAlphabetical ();
	public void run();
}