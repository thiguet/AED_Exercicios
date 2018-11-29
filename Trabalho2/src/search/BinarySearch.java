package search;
import java.util.List;

import model.Word;
import sort.ISort;
import sort.InsertionSort;
import util.Config;

public class BinarySearch extends AbstractSearch {
	private Word[] words;
	private int size;
	
	public BinarySearch(String fileName) {
		super(fileName);
		this.words = new Word [Config.TAM_MAX_PALAVRAS];
	}

	@Override
	public boolean exists(String word) {
		return false;
	}

	@Override
	public void add(List<String> content) {
		content .stream()
				.forEach(str -> {
					this.add(str);
					this.size++;
				});
	}
	
	private void add (String str, ) {
		
	}

	@Override
	public void printAlphabetical() {
		ISort<Word> sortObj = new InsertionSort<Word>();
		
		
	}
}
