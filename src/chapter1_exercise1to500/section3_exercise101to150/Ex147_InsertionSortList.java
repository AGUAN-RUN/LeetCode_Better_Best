package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

/*Sort a linked list using insertion sort.
A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list

Algorithm of Insertion Sort:
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain
*/
public class Ex147_InsertionSortList {
    //傻瓜式链表插入排序

    //用时 8ms  击败54.15的用户
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode result=head;
        ListNode st=head;
        ListNode end=head;
        ListNode next=null;
        head=head.next;
        //插入排序
        while(head!=null){
            if(head.val<result.val){
                //小与第一个
                next=head.next;
                end.next=next;
                st=head;
                st.next=result;
                result=st;
                head=next;
            }else if(head.val>=end.val){
                //大于等于尾巴节点
                end=head;
                head=head.next;
            }else {
                //之间
                next=head.next;
                end.next=next;
                ListNode lst=null;
                do{
                    lst=lst==null?st:lst.next;
                    st=st.next;
                    if(head.val<st.val){
                        lst.next=head;
                        head.next=st;
                        head=next;
                        break;
                    }
                }while (st!=end);
                st=result;
            }
        }
        return result;
    }
}
