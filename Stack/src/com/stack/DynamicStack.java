package com.stack;

public class DynamicStack extends CustomStack{
	public DynamicStack() {
		super();
	}
	
	DynamicStack(int size){
		super(size);
	}
	
	@Override
	public boolean push(Object data) {
		if(this.isFull()) {//this takes care if the stack is full
			Object[] temp = new Object[arr.length * 2];
			System.arraycopy(arr, 0, temp, 0, arr.length);
			arr=temp;
		}
		
		return super.push(data);
	}

}
