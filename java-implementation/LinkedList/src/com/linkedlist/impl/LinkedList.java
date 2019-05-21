package com.linkedlist.impl;

import java.util.List;

// Insert and Delete 
public class LinkedList<T> {
	
	private int SIZE=0;
	private Node<T> head;
	private Node<T> last;
	
	public LinkedList() {
	}
	
	public LinkedList(T... arr) {
		for(int i =0; i<arr.length ; i++) {
			this.add(arr[i]);
		}
	}
	
	public LinkedList(List<T> arr) {
		for(int i =0; i<arr.size() ; i++) {
			this.add(arr.get(i));
		}
	}
	
	public void insertAtHead(T data) {
		Node<T> newhead = LinkedListInsertUtil.insertAtHead(this.head, data);
		if(this.head == null) {
			this.last = newhead;
		}
		this.head = newhead;
		this.SIZE++;
	}
	
	public void reverseList() {
		this.head = LinkedListInsertUtil.reverseList(this.head);
	}
	
	public void insertInSortedOrder(T data) {
		Node<T> newhead = LinkedListInsertUtil.insertInSortedOrder(this.head, data);
		if(this.head == null) {
			this.last = newhead;
		}
		this.head = newhead;
		this.SIZE++;
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(this.head == null) {
			this.head = newNode;
			this.last = this.head;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		this.SIZE++;
	}
	
	public Node<T> getHead() {
		if(this.head == null)
			return null;
		else
			return this.head;
	}
	
	public int size() {
		return this.SIZE;
	}
	
	public void printElementR() {
		LinkedListPrintUtil.printListR(this.head);
	}
	
	public void printElement() {
		LinkedListPrintUtil.printList(this.head);
	}
	public void printListReverse() {
		LinkedListPrintUtil.printListReverse(this.head);
	}
	public void printListBoth() {
		LinkedListPrintUtil.printListBoth(this.head);
	}
}