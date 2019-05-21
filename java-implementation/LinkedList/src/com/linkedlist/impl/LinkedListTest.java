package com.linkedlist.impl;

public class LinkedListTest {
	
	public static void main(String...strings) {
		LinkedList<Integer> list = new LinkedList<Integer>(1,2,3,4,5,6,7,8,9);
//		System.out.println("Print Elements=>");
//		list.printElement();
		System.out.println("\nPrint List using Recursion=>");
		list.printElementR();
//		list.insertAtHead(0);
//		System.out.println("\nPrint List using Recursion=>");
//		list.printElementR();
		
//		list.insertInSortedOrder(0);
		list.insertInSortedOrder(89);
		list.insertInSortedOrder(50);
		list.insertInSortedOrder(10);
		list.insertInSortedOrder(15);
		System.out.println("\nPrint List using Recursion=>");
		list.printElementR();
		
		System.out.println("\nPrint Reverse List=>");
		list.reverseList();
		
		list.printElementR();
		
		
//		System.out.println("\nPrint Reverse List using Recursion=>");
//		list.printListReverse();
//		
//		System.out.println("\nPrint list in Forward and backward using Recursion=>");
//		list.printListBoth();
	}
}

