package chapter1_exercise1to500.section2_exercise51to100;

import commons.ListNode;
/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3


* */
public class Ex83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode iterator=head;
        int value=head.val;
        while(iterator.next!=null){
            if(iterator.next.val==value){
                iterator.next=iterator.next.next;
            }else{
                value=iterator.next.val;
                iterator=iterator.next;
            }
        }
        return head;
    }

}
