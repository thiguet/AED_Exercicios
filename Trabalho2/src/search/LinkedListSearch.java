package search;
import java.util.List;

import model.LinkedList;

public class LinkedListSearch extends AbstractSearch {
	private LinkedList words;
	
	public LinkedListSearch(String fileName) {
		super(fileName);
		words = new LinkedList ();
	}

	@Override
	public boolean exists(String word) {
		return false;
	}

	@Override
	public void add(List<String> content) {
		content .stream()
				.forEach( str -> words.add(str));	
		this.nrAttrNeeded = this.words.getNrAttribs();
		this.nrKeysCompared = this.words.getNrComps();
	}

	@Override
	public void printAlphabetical() {
		this.words.print();
	}

}
