package com.Queue;

public class CircularDeque {

}
class MyCircularDeque {
    protected int[] data;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public MyCircularDeque(int k) {
        this.data = new int[k];
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + data.length) % data.length; // move the front one step back 
        data[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[end++] = value;
        end = end % data.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        int removed = data[front++];
        System.out.println(removed);
        front = front % data.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
         if (isEmpty()) {
            return false;
        }

        end = (end - 1 + data.length) % data.length; // adding data.length is to ensure subtracion does not result in negative
        size--;
        return true;
    }
    
    public int getFront() {
         if(isEmpty()){
            return -1;
        }
        return data[front];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
         return data[(end - 1 + data.length) % data.length]; // end points to the next available slot, not the last valid element.
    }
    
    public boolean isEmpty() {
         return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */