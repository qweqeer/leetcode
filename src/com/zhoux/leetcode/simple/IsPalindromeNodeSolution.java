package com.zhoux.leetcode.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:treey
 * @create:2020/5/20
 **/
public class IsPalindromeNodeSolution {
    /**
     * 回文链表
     * https://leetcode-cn.com/problems/palindrome-linked-list/
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode start = head;
        Stack<Integer> stack = new Stack<>();
        while (start!=null){
            stack.push(start.val);
            start = start.next;
        }
        while (!stack.isEmpty()){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 翻转链表
     * https://leetcode-cn.com/problems/reverse-linked-list/
     */

    public ListNode reverseList(ListNode head) {
        if(null == head||head.next==null)
            return head;
        //TODO 链表的指针传递
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

}
