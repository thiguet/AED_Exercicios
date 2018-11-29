package model;

import java.util.ArrayList;
import java.util.List;

import util.Config;

public class Tree {
	private TreeNode root;
	private int size;
	private int nrComparations;
	private int nrAttribs;
	
	public Tree() {
		this.root = null;
		this.nrComparations = 0;
		this.nrAttribs = 0;
	}
     
    public boolean find(String str) {
        return find(root, str);
    }
    
	public boolean find(TreeNode node, String word) {
        boolean resp;
        int cmpWord = 0;
        
		if (node == null) {
            resp = false;
		} else {
			cmpWord = node.getWord().compareTo(word);
			if (cmpWord == 0) {
	            resp = true; 
	        } else if (cmpWord < 0) {
	            resp = find(node.left, word);
	        } else {
	            resp = find(node.right, word);
	        }
        }
		
		return resp;		
	}

	public List<Word> getTreeContent() {
		return null;
	}

	public TreeNode getRoot() {
		return root;
	}

	public int getNrComparations() {
		return nrComparations;
	}
	
    public int getHeight() {
        return getHeight(root);
    }
     
    private int getHeight(TreeNode node){
        if(node == null)
            return 0;
        else 
        	return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public void print() {
        print(root);
    }
 
    private void print(TreeNode node) {
        if (node != null) {
        	print(node.right); 
            Config.print(node.getWord().toString());
            print(node.left); 
        }
    }
 
    public void add(String word) {
        root = add(root, word);
        this.nrAttribs++;
    }
 
    private TreeNode add(TreeNode node, String word) {
    	if (node == null) { 
    		node = new TreeNode (word);
    		this.nrAttribs++;
    	    this.size++;
    	} else {
    		this.nrComparations++;
        	int cmpWords = node.getWord().compareTo(word);
        	
        	this.nrComparations++;
        	if(cmpWords == 0 ) {
        		node.getWord().plusFrequency();
            } else if (cmpWords < 0) {
                node.left = add(node.left, word);
                this.nrAttribs++;
        	} else if (cmpWords > 0) {
                node.right = add(node.right, word);
                this.nrAttribs++;
        	}
        }
         
        return node;
    }

	public int getSize() {
		return size;
	}

	public int getNrAttribs() {
		return this.nrAttribs;
	}
	
	public List<Word> toList() {
		List<Word> words = new ArrayList<Word> ();

		this.toList(root, words);
		
		return words;
	}
	
	private void toList(TreeNode node, List<Word> words) {
		if(node != null) {
			toList(node.left, words);
			words.add(node.getWord());
			toList(node.right, words);
		}
	}	
}
