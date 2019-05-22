package com.bt.impl;

public class BinaryTree<T> {

	// private int SIZE = 0;
	public Node<T> root;

	public int size() {
		return BTUtil.size(root);
	}
	
	public int maxDepth() {
		return BTUtil.maxDepth(root);
	}
	
	public void printPostorder()  { BTPrintUtil.printPostorder(root); } 
	public void printInorder()    { BTPrintUtil.printInorder(root); } 
	public void printPreorder()   { BTPrintUtil.printPreorder(root); }
	
	public void printLevelOrder() { 
        int h = maxDepth(); 
        int i; 
        for (i=1; i<=h; i++) 
        	BTUtil.printGivenLevel(root, i); 
    }
	
	
	public int getLeafCount() { 
        return BTUtil.getLeafCount(root); 
    } 
	
	public  boolean isBST()  { 
        return BTUtil.isBSTUtil(root, Integer.MIN_VALUE, 
                               Integer.MAX_VALUE); 
    }
}