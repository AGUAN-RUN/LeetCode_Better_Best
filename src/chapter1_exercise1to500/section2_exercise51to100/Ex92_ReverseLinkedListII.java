package chapter1_exercise1to500.section2_exercise51to100;

import commons.ListNode;
/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL


* */
public class Ex92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n)return head;
        ListNode result=head;
        ListNode lt=null;
        ListNode temp1=null;
        ListNode temp2=null;
        //不考虑特殊情况
        int index=1;
        while(index<=n){
            if(index==(m-1)){
                lt=head;
                head=head.next;
            }else if(index>=m){
                if(index==m){
                    temp1=head;
                    head=head.next;
                    temp1.next=null;
                }else{
                    temp2=head;
                    head=head.next;
                    temp2.next=temp1;
                    temp1=temp2;
                }
            }else{
                head=head.next;
            }
            index++;
        }
        if(lt!=null){
            if(head!=null)lt.next.next=head;
            lt.next=temp2;
            return result;
        }else{
            result.next=head;
            return temp2;
        }
    }
}