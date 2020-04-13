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
public class Ex141_LinkedListCycle {
    //head.val 不会为Integer.MIN_VALUE时的算法
    //0ms  击败100%用户
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        while(head!=null){
            if(head.val==Integer.MIN_VALUE)return true;
            head.val=Integer.MIN_VALUE;
            head=head.next;
        }
        return false;
    }
}
