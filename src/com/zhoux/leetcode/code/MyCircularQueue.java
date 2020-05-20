package com.zhoux.leetcode.code;

/**
 * @author:treey
 * @create:2020/5/20
 **/
public class MyCircularQueue {

    int[] vals;
    int head = 0;
    int tail = -1;
    int elementCount;
    int len;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        vals = new int[k];
        len = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(elementCount<len){
            if(tail+1==len){
                tail = 0;
                vals[tail] = value;
            }else{
                vals[++tail] = value;
            }
            elementCount++;
            return true;
        }
            return false;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty()?-1:vals[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()?-1:vals[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return elementCount == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return elementCount == len;
    }
}
