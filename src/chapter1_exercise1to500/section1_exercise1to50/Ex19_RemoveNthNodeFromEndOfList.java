package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？


* */
public class Ex19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k=1;
        ListNode temp=head;
        while(temp.next!=null){
            k+=1;
            temp=temp.next;
        }
        int rn=k-n+1;
        if(rn==1){
            head=head.next;
            return head;
        }
        temp=head;
        for(int j=2;j<rn;j++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

    }
}
