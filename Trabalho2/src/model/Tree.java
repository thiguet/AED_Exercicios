package model;

import java.util.List;

import util.Config;

public class Tree {
	private Node root;
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
    
	public boolean find(Node node, String word) {
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

	public Node getRoot() {
		return root;
	}

	public int getNrComparations() {
		return nrComparations;
	}
	
    public int getHeight() {
        return getHeight(root);
    }
     
    private int getHeight(Node node){
        if(node == null)
            return 0;
        else 
        	return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public void print() {
        print(root);
    }
 
    private void print(Node node) {
        if (node != null) {
        	print(node.left); 
            Config.print(node.getWord().toString());
            print(node.right); 
        }
    }
 
    public void add(String word) {
        root = add(root, word);
        this.nrAttribs++;
    }
 
    private Node add(Node node, String word) {
    	if (node == null) { 
    		node = new Node (word);
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
}