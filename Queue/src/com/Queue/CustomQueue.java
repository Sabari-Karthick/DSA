package com.Queue;

public class CustomQueue {
	
	protected Object[] arr;
	private static final int  DEFAULT_SIZE = 10;
	
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CustomQueue(int size) {
		this.arr= new Object[size];
	}

	
	int end = -1;
	

	public boolean isFull() {
		if(end == arr.length-1) {
			return true;
		}
		
		return false;
	}
	
	public boolean isEmpty() {
		if(end==-1) {
			return true;
		}
		return false;
	}
	
	public boolean insert(Object data) {
		if(isFull()) {
			return false;
		}
		end++;
		arr[end]=data;
		return true;
	}
	
	public Object remove() throws Exception {// O(N)
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
			
		}
		Object data = arr[0];
		for(int i=0;i<=end;i++) {
			arr[i]=arr[i+1];
		}
		end--;
		return data;
	}
	
	public void display() {
		for(int i=0;i<=end;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
