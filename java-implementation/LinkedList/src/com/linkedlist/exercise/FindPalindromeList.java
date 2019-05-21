package com.linkedlist.exercise;

import com.linkedlist.impl.LinkedList;
import com.linkedlist.impl.LinkedListInsertUtil;
import com.linkedlist.impl.LinkedListPrintUtil;
import com.linkedlist.impl.Node;

public class FindPalindromeList {

	public static void main(String...strings) {
		LinkedList<String> list = new LinkedList<String>("A","B","B","A" );
//		LinkedList<String> list = new LinkedList<String>("A","B","X","B","A" );
		System.out.println("\nPrint List using Recursion=>");
		list.printElementR();
		if(findPalindrome(list))
			System.out.println("\nList is palindrome");
		else
			System.out.println("\nList is not palindrome");
		
		System.out.println("\nPrint List using Recursion=>");
		list.printElementR();
	}
	
	public static boolean findPalindrome(LinkedList<String> list) {
		
		Node<String> head = list.getHead() , revMid = null;
		
		if(list == null || head == null || head.next == null)
			return true;
		
		boolean flag = true;
		
		int half = list.size() / 2, c = 0;
		
		while(c < half) {
			head = head.next;
			c++;
		}

		revMid = head;

		System.out.println("\nPrint Mid List=>");		
		LinkedListPrintUtil.printList(revMid);
		
		revMid = LinkedListInsertUtil.reverseList(revMid);
		
		System.out.println("\nPrint Mid Reverse List=>");		
		LinkedListPrintUtil.printList(revMid);
		
		head = list.getHead();
		
		while(half>=0 && head != null && revMid != null) {
			if(head.data != revMid.data) {
				flag = false;
				break;
			} else {
				head = head.next;
				revMid = revMid.next;
			}
			half--;
		}
		return flag;
	}
}