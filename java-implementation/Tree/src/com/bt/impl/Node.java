package com.bt.impl;

public class Node<T> {
	
	public T data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(T data) {
		this.data = data;
	    left = right = null; 
	}
	
	public Node(T data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
