package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

/*
* Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
*
* Follow up:
Can you solve it using O(1) (i.e. constant) memory?
*
* */
public class Ex141_LinkedListCycle_2 {
    //快慢指针法
    //0ms  击败100%用户
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode lowNode=head;
        ListNode fastNode=head.next;
        while(fastNode!=lowNode){
            if(lowNode!=null)lowNode=lowNode.next;
            if(fastNode!=null)fastNode=fastNode.next;
            if(fastNode!=null)fastNode=fastNode.next;
        }
        if(lowNode!=null)return true;
        return false;
    }
}
