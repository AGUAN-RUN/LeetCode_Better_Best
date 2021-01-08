package chapter1_exercise1to500.section2_exercise51to100;

import commons.ListNode;
/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3


* */
public class Ex82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        //加个火车头方便处理链表
        ListNode result=new ListNode(0);
        result.next=head;
        head=result;
        while(head.next!=null&&head.next.next!=null){
            if(head.next.next.val==head.next.val){
                int value=head.next.val;
                head.next=head.next.next.next;
                while(head.next!=null&&head.next.val==value){
                    head.next=head.next.next;
                }
            }else{
                head=head.next;
            }
        }
        return result.next;
    }
}