package _0019_removeNthFromEnd;

/**
 * @author hzdmm123
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode first = fake;
        ListNode second = fake;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return fake.next;

    }
}
