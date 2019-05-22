package com.queue.ll.impl;

public class Queue<T> {
	
	Node<T> front, rear;
	
	public Queue() {
		front = rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public void insert(T data) {
		Node<T> temp = new Node<T>(data);
		if(isEmpty())
			front = rear = temp;
		else {
			rear.next = temp;
			rear = temp;
		}
	}
	
	public T remove() throws Exception {
		if(isEmpty())
			throw new Exception("Queue is already Emply");
		T temp = front.data;
		front = front.next;
		if(front == null)
			rear = null;
		return temp;
	}
	
}
class Node <T> {
	public T data; 
	public Node<T> next;
	
	public Node(T val)	{
		data = val;
		next = null;
	}
}