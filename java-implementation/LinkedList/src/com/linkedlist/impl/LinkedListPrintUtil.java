package com.linkedlist.impl;

public class LinkedListPrintUtil {
	
	public static <T> void printListBoth(Node<T> head) {
		if(head == null)
			return;
		if(head.next == null) {
			System.out.print(head.data+" ");
			return;
		}
		System.out.print(head.data+" ");
		printListBoth(head.next);
		System.out.print(head.data+" ");
	}
	
	public static <T> void printListReverse(Node<T> head) {
		if(head == null)
			return;
		printListReverse(head.next);
		System.out.print(head.data+" ");
	}
	
	public static <T> void printListR(Node<T> head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		printListR(head.next);
	}
	
	public static <T> void printList(Node<T> head) {
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
}
