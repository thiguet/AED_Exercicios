package model;

public class SimpleListNode extends Node {
	private SimpleListNode next;
	
	public SimpleListNode() {}
	
	SimpleListNode(String str) {
		this.word = new Word(str);
	}

	public SimpleListNode getNext() {
		return next;
	}

	public void setNext(SimpleListNode next) {
		this.next = next;
	}
}
