package com.linkedlist.impl;

public class Node<T> {
	
	public T data;
	public Node<T> next = null;
	// public Node<T> perv = null; 
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}