package model;

import java.util.ArrayList;
import java.util.List;

import sort.ISort;
import sort.InsertionSort;
import util.Config;

public class LinkedList {
	private SimpleListNode first;
	private SimpleListNode end;
	private int nrAttribs;
	private int nrComps;
	
	public LinkedList() {
		this.first = this.end = new SimpleListNode ();
	}

	public SimpleListNode getFirst() {
		return first;
	}

	public void setFirst(SimpleListNode first) {
		this.first = first;
	}

	public SimpleListNode getEnd() {
		return end;
	}

	public void setEnd(SimpleListNode end) {
		this.end = end;
	}
	
	public boolean exists (String str) {
		SimpleListNode smpNode = this.first.getNext();
		Word aux = null;

		while(smpNode != null) {
			aux = smpNode.getWord();
			this.nrComps++;
			if(aux.getWord().equals(str))
				return true;
			
			smpNode = smpNode.getNext();
		}
		
		return false;
	}
	
	public void add(String str) {
		SimpleListNode smpNode;
		
		this.nrComps++;
		if(exists(str)) {
			this.find(str).plusFrequency();
		} else {
			smpNode = new SimpleListNode (str);
			this.nrAttribs++;
			
			this.nrComps++;
			if(first == end) {
				first.setNext(smpNode);
				this.nrAttribs++;
			}
			
			end.setNext(smpNode);
			this.nrAttribs++;
			
			end = end.getNext();
			this.nrAttribs++;
			
			end.setNext(null);
			this.nrAttribs++;
		}
	}
	
	private Word find (String str) {
		SimpleListNode smpNode = this.first.getNext();
		Word aux = null;
		
		while(smpNode != null) {
			this.nrAttribs++;
			aux = smpNode.getWord();
			if(aux.getWord().equals(str))
				return aux;

			this.nrAttribs++;
			smpNode = smpNode.getNext();
		}
		
		return aux;
	}
	
	public void print () {
		SimpleListNode smpNode = this.first.getNext();
		List<Word> words = new ArrayList <Word> ();
		
		while(smpNode != null) {
			words.add(smpNode.getWord());
			smpNode = smpNode.getNext();
		}
		
		ISort<Word> sortObj = new InsertionSort<Word>();
		sortObj.sort(words);
		
		for(Word word : words) {
			Config.print(word.toString());
		}
	}

	public int getNrAttribs() {
		return nrAttribs;
	}

	public int getNrComps() {
		return nrComps;
	}
}	
