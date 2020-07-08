package _0876_middleNode;

import common.ListNode;

/**
 * @author hzdmm123
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution {

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        System.out.println(testCase1());
        System.out.println(testCase2());

    }

    public static Boolean testCase1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode test = middleNode(a);
        return test.val == 3;
    }

    public static Boolean testCase2() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode test = middleNode(a);
        return test.val == 2;
    }

}
