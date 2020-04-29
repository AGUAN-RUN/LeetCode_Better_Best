package chapter1_exercise1to500.section5_exercese201to250;

import commons.ListNode;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
* */
public class Ex234_PalindromeLinkedList_2 {
    //不使用额外空间  时间复杂度O(n)  空间复杂读O(1)  断链修改链表的做法

    //用时1ms 击败99.82%
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int mid=length/2;
        int i=1;
        //反转链表的同时找到中间节点
        ListNode pre=head;
        temp=head.next;
        head.next=null;
        while (i<mid){
            ListNode listNode=temp.next;
            temp.next=pre;
            pre=temp;
            temp=listNode;
            i++;
        }
        //操作 pre和temp
        if(length%2!=0)temp=temp.next;
        while(temp!=null){
            if(temp.val!=pre.val)return false;
            temp=temp.next;
            pre=pre.next;
        }
        return true;
    }
}
