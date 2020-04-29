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
public class Ex234_PalindromeLinkedList {
    //用时1ms  击败99.82%
    public boolean isPalindrome(ListNode head) {
        //使用额外空间 先获取长度 初始化数组 填充数组 判断
        if(head==null||head.next==null)return true;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int[]nums=new int[length];
        temp=head;
        int i=0;
        while (temp!=null){
            nums[i++]=temp.val;
            temp=temp.next;
        }
        int j=0;
        i--;
        while(j<i){
            if(nums[i--]!=nums[j++])return false;
        }
        return true;
    }
}
