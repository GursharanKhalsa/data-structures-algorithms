package com.linkedlist.impl;

public class LinkedListInsertUtil {
	
	public static <T> Node<T> reverseList(Node<T> h) {
		if(h==null || h.next == null) {
			return h;
		}
		Node<T> newH = null;
		while(h != null) {
			Node<T> temp = h;
			h = h.next;
			temp.next = newH;
			newH = temp;
		}
		return newH;
	}
	
	public static <T> Node<T> insertAtHead(Node<T> head , T data) {
		Node<T> newNode = new Node<T>(data);
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	public static <T> Node<T> insertInSortedOrder(Node<T> head , T data) {
		Node<T> newNode = new Node<T>(data);
		
		// INSERT AT HEAD
		while(head == null || ((Integer) head.data ) > ((Integer)data)) {
			System.out.println("\nInsert in head");
			newNode.next = head;
			return newNode;
		}
		Node<T> oriHead = head;
		
		while(head.next != null && ((Integer)head.next.data) < ((Integer)data)) 
			head = head.next;
		
		// INSERT AFTER Head
		newNode.next = head.next;
		head.next = newNode;
		
		return oriHead;
	}
}