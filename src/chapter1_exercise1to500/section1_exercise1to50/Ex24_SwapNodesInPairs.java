package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;

public class Ex24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;
        while(p.next != null && p.next.next != null) {
            ListNode node1 = p.next, node2 = p.next.next, next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummy.next;
    }
}
