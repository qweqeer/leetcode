package leetcode.editor.cn.model;

/**
 * @author zhoux
 * @create 2022-05-05 5:10 PM
 **/
public class ListNode {
    public int val;

    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
