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
public class Ex234_PalindromeLinkedList_3 {
    //在第二次提交的基础上略加改进
    //不使用额外空间  时间复杂度O(n)  空间复杂读O(1)  使用快慢指针算法 找到中点再反转后半部分链表进行比较


    public boolean isPalindrome(ListNode head) {
        /*if(head==null||head.next==null)return true;

        //快慢指针找中点  然后反转后面的链表

        //操作 pre和temp
        if(length%2!=0)temp=temp.next;
        while(temp!=null){
            if(temp.val!=pre.val)return false;
            temp=temp.next;
            pre=pre.next;
        }
        return true;
    }*/
}
