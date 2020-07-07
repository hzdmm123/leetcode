package _0092_reverseBetween;

import common.ListNode;

import java.util.List;

/**
 * @author hzdmm123
 */
public class solution {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return head;
        }
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode tail = head;
        int delta = n - m;
        ListNode pre = fakeNode;

        // 找到起点
        while (m > 1) {
            pre = tail;
            tail = tail.next;
            m--;
        }

        while (delta > 0) {
            ListNode next = tail.next;
            tail.next = next.next;
            next.next = pre.next;
            pre.next = next;
            delta--;

        }

        return fakeNode.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode test = reverseBetween(a, 2, 4);
        // expect : 1 4 3 2 5
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }


    }
}
