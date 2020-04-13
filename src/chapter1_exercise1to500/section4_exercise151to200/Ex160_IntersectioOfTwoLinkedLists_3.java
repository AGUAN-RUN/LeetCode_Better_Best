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
public class Ex160_IntersectioOfTwoLinkedLists_3 {
    //比较巧妙的解法。两个指针，指针A遍历完第一个链表后遍历第二个，指针B遍历完第一个链表后遍历第一个，走完了没有牵手就没有相交

    //上一个解法进行部分的优化

    //用时1ms  击败99.98%的用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode headA1=headA;
        ListNode headB1=headB;

        while(headA1!=headB1){
          headA1=headA1==null?headB:headA1.next;
          headB1=headB1==null?headA:headB1.next;
        }
        return headA1;
    }
}
