package search;
import java.util.ArrayList;
import java.util.List;

import model.Tree;
import model.Word;
import sort.ISort;
import sort.InsertionSort;
import util.Config;

public class HashSearch extends AbstractSearch {
	private int size;
	private Word[] table;
	private Tree reservedArea;
	
	public HashSearch(String fileName) {
		super(fileName);
		size = Config.TAM_MAX_PALAVRAS;
		table = new Word [size];	
		reservedArea = new Tree ();
	}
	
	@Override
	public boolean exists(String word) {
		return false;
	}

	@Override
	public void add(List<String> content) {
		content.stream()
			   .forEach(str -> this.addTable(str));
	}

	private void addTable(String str) {
		int hash = hash(str);
		this.nrAttrNeeded++;
		
		Word word;
		this.nrKeysCompared++;
		if(table[hash] == null) {
			word = new Word(str);
			this.nrAttrNeeded++;
	
			table[hash] = word;
			this.nrAttrNeeded++;
		} else {
			this.nrKeysCompared++;
			if(table[hash].getWord().equals(str)) {
				table[hash].plusFrequency();
			} else {
				this.addInReservedArea(str);
			}
		}
	}
	
	@Override
	public void printAlphabetical() {
		List<Word> list = new ArrayList<Word> (), 
				   aux;
		
		for(int i = 0; i < this.table.length ; i++) {
			if(this.table[i] != null)				
				list.add(this.table[i]);
		}
		
		aux = this.reservedArea.toList();
		
		aux.stream()
		   .forEach( word -> list.add(word));
		
		ISort<Word> sortObj = new InsertionSort <Word> (); 
		sortObj.sort(list);
		
		for(Word word : list) {
			Config.print(word.toString());
		}
	}
	
	private int hash(String key) {
		int hash = key.hashCode();
		
		this.nrAttrNeeded++;
		
		return (hash % this.size) * ((hash > 0)
					? 1
					: -1);
	}
	
	private void addInReservedArea (String str) {
		reservedArea.add(str);
		this.nrAttrNeeded += reservedArea.getNrAttribs();
	}
}
