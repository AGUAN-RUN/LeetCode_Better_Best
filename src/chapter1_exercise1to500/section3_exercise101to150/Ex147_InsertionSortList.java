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
/*
对链表进行插入排序。


插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5


* */
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
