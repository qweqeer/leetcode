package com.zhoux.leetcode.simple;


/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 1、采用辅助链表保存最小值
 * 2、在最小值发生变化时把之前的值重新入，如果出栈的时最小值，那么栈顶就是最新的最小值
 * 3、
 */
public class MinStack {

    Node header = null;
    Node minNode = null;
    class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public MinStack() {
    }

    public void push(int x) {
        Node node=new Node(x);
        node.next = header;
        header = node;

        if(null == minNode){
            minNode = minNode==null?new Node(x):minNode;
        }else{
            if(minNode.value>=x){
                Node newMIn = new Node(x);
                newMIn.next= minNode;
                minNode = newMIn;
            }
        }
    }

    public void pop() {

        if(minNode.value==header.value){
            minNode = minNode.next;
        }
        header = header.next;
    }

    public int top() {
        return header!=null?header.value:0;
    }

    public int getMin() {
        return minNode.value;
    }

}
