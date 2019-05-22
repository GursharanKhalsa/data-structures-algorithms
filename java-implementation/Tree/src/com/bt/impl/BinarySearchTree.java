package com.bt.impl;

public class BinarySearchTree<T> extends BinaryTree<T> {

	BinarySearchTree() {
		root = null;
	}
	
	public void insert(T value) {
		this.root = insert(root, value);
	}
	
	public Node<T> insert(Node<T> root, T value) { 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node<T>(value); 
            return root; 
        }
        /* Otherwise, recur down the tree */
        if (  (Integer) value <  (Integer) root.data) 
            root.left = insert(root.left, value); 
        else if ( (Integer) value >  (Integer)  root.data) 
            root.right = insert(root.right, value); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
}