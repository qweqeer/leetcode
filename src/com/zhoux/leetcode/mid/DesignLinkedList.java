package com.zhoux.leetcode.mid;

/**
 * @author:zhouxiang
 * @date:2020-06-12
 * @describe:
 * @status:
 */
class MyLinkedList {
    
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    int len;
    
    Node head;
    
    Node tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        len=0;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(null == head || null == tail || index>len){
            return -1;
        }
        Node node = head;
        for (int tmpIndex = 0; tmpIndex <len ; tmpIndex++) {
            node = node.next;
        }
        return node.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        final Node oldHead = head;
        Node node = new Node(val);
        
        if(null==head||null==tail){
            head=node;
            tail = node;
        }else{
            node.next = oldHead;
            head = node;
        }
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        final Node oldTail = tail;
        Node node = new Node(val);
        
        if(null==head||null==tail){
            head=node;
            tail = node;
        }else{
            oldTail.next = node;
            tail = oldTail;
        }
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<=0){
            addAtHead(val);
        }else if(index>len){
            addAtTail(val);
        }else {
            Node tmp=head;
            for (int i = 0; i < index-1; i++) {
                tmp = tmp.next;
            }
            Node node = new Node(val);
            node.next = tmp.next;
            tmp.next = node;
            head = tmp;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index > len){
            return;
        }
        if(index==0){
            head = head.next;
            if(len==1){
                tail=null;
            }
            len--;
            return;
        }
        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
    
    
}

