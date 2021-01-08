package chapter1_exercise1to500.section2_exercise51to100;

import commons.ListNode;
/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5


* */
public class Ex86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        //对原来的链表做一次便利，小于x的节点放到链表node1中，再加大于等于x的节点放到链表node2中,最后整和起来并返回
        //击败100%
        ListNode node1=new ListNode(-1);
        ListNode node1Tem=node1;
        ListNode node2=new ListNode(-1);
        ListNode node2Tem=node2;
        while(head!=null){
            if(head.val<x){
                node1Tem.next=new ListNode(head.val);
                node1Tem=node1Tem.next;
            }else{
                node2Tem.next=new ListNode(head.val);
                node2Tem=node2Tem.next;
            }
            head=head.next;
        }
        //下面这行其实可以去掉，因为后面的返回代码其实已经包含了这种情况
        if(node1.next==null)return node2.next;
        node1Tem.next=node2.next;
        return node1.next;
    }
}
