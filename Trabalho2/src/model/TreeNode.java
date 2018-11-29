package model;

public class TreeNode extends Node {
	public TreeNode left;
	public TreeNode right;
	
	TreeNode() {}
	
	TreeNode(String str) {
		this.word = new Word(str);
	}
}
