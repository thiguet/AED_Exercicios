package model;

public class Word implements Comparable<Word> {
	private String str;
	private int frequency;
	
	public Word() {
		this.str = "";
		this.frequency = 1;
	}
	
	public Word(String word) {
		this.str = word;
		this.frequency = 1;
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
	public int compareTo(Word word) {
		return this.str.compareTo(word.getWord());
	}

	public int compareTo(String str) {
		return this.str.compareTo(str);
	}
	
	@Override
	public String toString() {
		return this.str + " -> " + this.frequency;
	}
}