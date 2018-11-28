package model;

public class HashTable {
	private int size;
	
	public int hash(int key) {
		return key % size; 
	}
	
	public int rehash (int key) {
		return ++key % size;
	}
}
