package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;

public class Ex2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode=null;
        ListNode result=null;
        ListNode n1=l1;
        ListNode n2=l2;
        int flag=0;
        int temp=0;
        if(n1!=null||n2!=null){
            if(n1!=null){
                temp+=n1.val;
                n1=n1.next;
            }
            if(n2!=null){
                temp+=n2.val;
                n2=n2.next;
            }
            temp+=flag;
            flag=0;
            if(temp>=10){
                temp-=10;
                flag=1;
            }
            resultNode=new ListNode(temp);
            temp=0;
            result=resultNode;
        }
        while(n1!=null||n2!=null){
            if(n1!=null){
                temp+=n1.val;
                n1=n1.next;
            }
            if(n2!=null){
                temp+=n2.val;
                n2=n2.next;
            }
            temp+=flag;
            flag=0;
            if(temp>=10){
                temp-=10;
                flag=1;
            }
            result.next=new ListNode(temp);
            temp=0;
            result=result.next;

        }
        if(flag==1)result.next=new ListNode(1);
        return resultNode;
    }
}
