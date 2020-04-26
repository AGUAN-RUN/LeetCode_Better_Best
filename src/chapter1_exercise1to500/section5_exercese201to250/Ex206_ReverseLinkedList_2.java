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
public class Ex206_ReverseLinkedList_2 {
    //recursively

    //用时19ms  击败6.75%的提交
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode result=reverseList(head.next);
        head.next=null;
        ListNode temp=result;
        //这一步使得时间复杂度  达到了 O(N!)  可以用一个临时节点直接保存head的下一个元素，而不是拿到下一层递归结果后进行遍历
        while(temp.next!=null)temp=temp.next;
        temp.next=head;
        return result;
    }
}
