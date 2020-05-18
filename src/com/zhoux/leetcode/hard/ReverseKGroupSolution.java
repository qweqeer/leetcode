package com.zhoux.leetcode.hard;


/**
 * @author:treey
 * @create:2020/5/16
 **/
public class ReverseKGroupSolution {
    /**
     * K个一组的翻转链表
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        result.next = head;
        //前置节点
        ListNode pre = result;
        //第k个节点
        ListNode end = result;

        while (end.next != null) {
            //获取每组的第K个节点
            for (int i = 0; i < k && end != null; i++) end = end.next;
            //剩余节点数小于K
            if (end == null) break;

            //需要反转的起始节点
            ListNode start = pre.next;
            //保存下一组的头节点
            ListNode next = end.next;
            //将第K+1个节点置为空，此时start节点的长度为K
            end.next = null;

            //当前pre为组的前置节点
            pre.next = reverse(start);
            //链接未遍历的组
            start.next = next;
            //
            pre = start;

            end = pre;
        }
        return result.next;
    }

    /**
     * 链表反转
     */
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                    new ListNode(4,
                                        new ListNode(5))
                                        )));
        ReverseKGroupSolution solution = new ReverseKGroupSolution();
        solution.reverseKGroup(root,2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
