package chapter1_exercise1to500.section5_exercese201to250;

import commons.ListNode;

/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
* */
public class Ex206_ReverseLinkedList {
    //iteratively

    //用时0ms  击败100%的提交
    public ListNode reverseList(ListNode head) {
        if(head==null)return head;
        ListNode next=head.next;
        ListNode pre=head;
        pre.next=null;

        while(next!=null){
            next.next=pre;
            pre=next;
            next=next.next;
        }
        return pre;
    }
}
