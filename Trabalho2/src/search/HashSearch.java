package search;
import java.util.List;

import model.Tree;
import model.Word;

public class HashSearch extends AbstractSearch {
	// Alphabet Chars
	private final int MAX_HASH_ENTRIES = 26;

	private Word[] table;
	private Tree reservedArea;
	
	HashSearch(String fileName) {
		super(fileName);
		table = new Word [MAX_HASH_ENTRIES];	
	}
	
	@Override
	
	public boolean exists(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(List<String> content) {
		content.stream()
			   .forEach(str -> this.addTable(str));
	}

	private void addTable(String str) {
		int hash = hash(str);
		Word word;
		
		if(table[hash] == null) {
			word = new Word(str);
			table[hash] = word;
		} else {
			if(table[hash].getWord().equals(str)) {
				table[hash].plusFrequency();
			} else {
				this.addInReservedArea(str);
			}
		}
	}
	
	@Override
	public void printAlphabetical() {
		
	}
	
	private int hash(String key) {
		return key.hashCode();
	}
	
	private void addInReservedArea (String str) {
		reservedArea.add(str);
	}
}
