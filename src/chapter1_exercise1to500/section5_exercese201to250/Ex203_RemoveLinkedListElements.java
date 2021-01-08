package chapter1_exercise1to500.section5_exercese201to250;

import commons.ListNode;

import java.util.List;

/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/
/*
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
* */
public class Ex203_RemoveLinkedListElements {
    //用时1ms  击败99.9 的提交
    public ListNode removeElements(ListNode head, int val) {
         ListNode newHead=new ListNode(-1);
         newHead.next=head;
         ListNode temp=newHead;
         while (head!=null){
             if(head.val==val){
                 temp.next=head.next;
             }else {
                 temp=head;
             }
            head=head.next;
         }
         return newHead.next;
    }
}
