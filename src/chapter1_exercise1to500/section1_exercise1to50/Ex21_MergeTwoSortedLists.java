package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;
/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4


* */
public class Ex21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode  temp2=l2;
        ListNode  result=null;
        ListNode  tempRt=null;
        if(l1==null&&l2==null){
            return null;
        }else{
            if(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    result=l1;
                    tempRt=result;
                    temp1=temp1.next;
                }else{
                    result=l2;
                    tempRt=result;
                    temp2=temp2.next;
                }
            }else if(l1==null){
                return l2;
            }else if(l2==null){
                return l1;
            }

        }

        while((temp1!=null||temp2!=null)&&tempRt!=null){
            if(temp1!=null&&temp2!=null){
                if(temp1.val<=temp2.val){
                    tempRt.next=temp1;
                    tempRt=tempRt.next;
                    temp1=temp1.next;
                }else{
                    tempRt.next=temp2;
                    tempRt=tempRt.next;
                    temp2=temp2.next;
                }

            }else if(temp1==null){
                tempRt.next=temp2;
                return result;
            }else if(temp2==null){
                tempRt.next=temp1;
                return result;
            }
        }
        return result;
    }
}
