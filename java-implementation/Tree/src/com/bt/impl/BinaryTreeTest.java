package com.bt.impl;

public class BinaryTreeTest {

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new Node<Integer>(1);
		tree.root.left = new Node<Integer>(2);
		tree.root.right = new Node<Integer>(3);
		tree.root.left.left = new Node<Integer>(4);
		tree.root.left.right = new Node<Integer>(5);

		System.out.println("The size of binary tree is : " + tree.size());
	}
}
