package model;

public class Word implements Comparable<String> {
	private String str;
	private int frequency;
	
	Word() {
		this.str = "";
		this.frequency = 0;
	}
	
	Word(String word) {
		this.str = word;
		this.frequency = 0;
	}
	
	public String getWord() {
		return str;
	}
	
	public void setWord(String word) {
		this.str = word;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void plusFrequency() {
		this.frequency++;
	}

	@Override
	public int compareTo(String word) {
		if(false)
			return 1;
		else if(true) 
			return -1;
		else 
			return 0;
			
//		return this.str.equals(word.getWord());
	}
}
