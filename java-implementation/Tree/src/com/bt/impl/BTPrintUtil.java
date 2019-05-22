package com.bt.impl;

public class BTPrintUtil {

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up" postorder
	 * traversal.
	 */
	public static <T> void printPostorder(Node<T> node) {
		if (node == null)
			return;
		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.data + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	public static <T> void printInorder(Node<T> node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	public static <T> void printPreorder(Node<T> node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.data + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}
	
	public static <T> void printLeafCount(Node<T> node) { 
        if (node == null) 
            return; 
        if (node.left == null && node.right == null) 
            System.out.println(node.data+" "); 
        
        printLeafCount(node.left);
        printLeafCount(node.right); 
    }
}