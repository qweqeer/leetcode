package leetcode.editor.cn;//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1590 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

import leetcode.editor.cn.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SortListSolution {
    public ListNode sortList(ListNode head) {
        /**
         * 快慢指针=>获取链表中点,分开排序
         * 归并排序=>两个有序链表
         * 局部排序
         * 时间复杂度：N*O(logN) => 二分
         */
        return sort(head,null);
    }

    private ListNode sort(ListNode head,ListNode tail){
        //当前节点无需排序
        if(head == null || head.next == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head,slow = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        ListNode back = sort(slow,tail);
        ListNode front = sort(head,slow);
        return merge(front,back);
    }

    private ListNode merge(ListNode front,ListNode back){
        if(null == front){
            return back;
        }
        if(null == back){
            return front;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (null!=front && null!=back){
            if(front.val<= back.val){
                cur.next = front;
                cur = cur.next;
                front= front.next;
                if(front == null){
                    cur.next = back;
                }
            }else{
                cur.next = back;
                cur = cur.next;
                back = back.next;
                if(back == null){
                    cur.next = front;
                }
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        SortListSolution solution = new SortListSolution();
        ListNode node  = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3,new ListNode(-1)))));
        ListNode head =solution.sortList(node);
        System.out.println("done");
    }

}
//leetcode submit region end(Prohibit modification and deletion)
