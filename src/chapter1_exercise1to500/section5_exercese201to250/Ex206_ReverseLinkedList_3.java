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
public class Ex206_ReverseLinkedList_3 {
    //recursively

    //在2递归方法的基础上优化  时间复杂度 O(n)
    //用时0ms  击败100%的提交
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode temp=head.next;
        ListNode result=reverseList(head.next);
        head.next=null;
        temp.next=head;
        return result;
    }
}
