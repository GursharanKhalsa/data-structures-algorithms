package com.queue.arr.impl;

public class Queue<T> {
	
	Object arr[];
	int rear = -1;

	public Queue() {
		arr = new Object[10];
	}
	
	public Queue(int size) {
		arr = new Object[size];
	}
	
	public void insert(T k) throws Exception {
		if (isFull())
			throw new Exception("Queue is full");

		arr[rear + 1] = k;
		rear++;
	}

	public T remove() throws Exception{
		if (isEmpty())
			throw new Exception("Queue is emply");

		T temp = (T) arr[0];
		for (int i = 0; i < rear; i++)
			arr[i] = arr[i + 1];
		rear--;

		return temp;
	}

	public boolean isFull() {
		return (rear >= 10);
	}

	public boolean isEmpty() {
		return (rear == -1);
	}
}