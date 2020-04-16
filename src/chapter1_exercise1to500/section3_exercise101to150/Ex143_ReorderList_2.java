package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
public class Ex143_ReorderList_2 {

    //试试直接用数组
    //用时1ms  击败100%的用户
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return;
        //重塑链表
        ListNode next=head;
        int length=0;
        while(next!=null){
            length++;
            next=next.next;
        }
        ListNode[]temp=new ListNode[length];
        next=head;
        int index=0;
        while(head!=null){
            head=head.next;
            next.next=null;
            temp[index++]=next;
            next=head;
        }
        length--;
        for(int i=0;i<=length;i++){
            if(i==length-i)break;
            temp[i].next=temp[length-i];
            if(i+1==length-i)break;
            temp[length-i].next=temp[i+1];
        }
    }
}
