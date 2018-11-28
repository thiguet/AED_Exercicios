import java.util.List;

public interface Search {
	public boolean exists (String word);
	public void add(List<String> content);
	public void alphabeticalPrint ();
	public void run();
}