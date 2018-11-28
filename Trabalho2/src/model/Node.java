package model;

public class Node {
	public Node left;
	public Node right;
	private Word word;
	
	Node() {}
	
	Node(String str) {
		this.word = new Word(str);
	}
	
	public Word getWord() {
		return word;
	}
	
	public void setWord(Word word) {
		this.word = word;
	}
}
