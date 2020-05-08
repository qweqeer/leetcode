package com.zhoux.leetcode.mid;

public class AddTwoNumbersSolution {
    /**
     * 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/
     */



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2)
            return l1;

        ListNode result =new ListNode(0);
        ListNode res = result;
        int nextSum = 0;
        while (l1 != null|| l2!=null){
            if(l1==null){
                l1 = new ListNode(0);
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            int value1 = null==l1?0:l1.val;
            int value2 = null==l2?0:l2.val;

            res.next = new ListNode((nextSum+value1+value2)%10);
            nextSum = (nextSum+value1+value2)/10;
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        if(nextSum!=0){
            res.next = new ListNode(nextSum);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3,new ListNode(5,new ListNode(8)));

        ListNode l2 = new ListNode(3,new ListNode(5,new ListNode(8,new ListNode(9))));
        //6.0.7.0.1
        ListNode res = addTwoNumbers(l1, l2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
