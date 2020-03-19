package chapter1_exercise1to500.section2_exercise51to100;

import commons.ListNode;

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