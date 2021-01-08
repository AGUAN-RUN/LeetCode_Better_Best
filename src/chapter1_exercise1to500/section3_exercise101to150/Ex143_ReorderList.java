package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.


* */
public class Ex143_ReorderList {

    //用时4ms 击败27.41的用户
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return;
        //重塑链表
        List<ListNode> temp=new ArrayList<>();
        ListNode next=head;
        while(head!=null){
            head=head.next;
            next.next=null;
            temp.add(next);
            next=head;
        }
        int length=temp.size()-1;
        for(int i=0;i<=length;i++){
            if(i==length-i)break;
            temp.get(i).next=temp.get(length-i);
            if(i+1==length-i)break;
            temp.get(length-i).next=temp.get(i+1);
        }
    }
}
