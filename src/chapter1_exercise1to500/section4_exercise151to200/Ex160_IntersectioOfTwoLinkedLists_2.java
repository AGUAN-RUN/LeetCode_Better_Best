package chapter1_exercise1to500.section4_exercise151to200;

import commons.ListNode;

/*Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class Ex160_IntersectioOfTwoLinkedLists_2 {
    //比较巧妙的解法。两个指针，指针A遍历完第一个链表后遍历第二个，指针B遍历完第一个链表后遍历第一个，走完了没有牵手就没有相交

    //用时2ms  击败41.42%的用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA1=headA;
        ListNode headB1=headB;
        int status=0;
        while(headA1!=null&&headB1!=null){
            if(headA1==headB1)return headA1;
            headA1=headA1.next;
            headB1=headB1.next;
            if(headA1==null&&status<2){
                headA1=headB;
                status++;
            }
            if(headB1==null&&status<2){
                headB1=headA;
                status++;
            }
        }
        return null;
    }
}
