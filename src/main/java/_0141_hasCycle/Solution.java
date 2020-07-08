package _0141_hasCycle;

import common.ListNode;

/**
 * @author hzdmm123
 * 快慢指针找到环
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while (slowNode != fastNode) {

            if (fastNode==null||fastNode.next==null){
                return false;
            }

            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

        }
        return true;
    }
}
