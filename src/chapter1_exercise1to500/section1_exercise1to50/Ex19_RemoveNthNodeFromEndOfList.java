package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;

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
