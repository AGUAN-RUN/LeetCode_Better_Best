package chapter1_exercise1to500.section4_exercise151to200;

import commons.ListNode;
import commons.Node;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/*Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class Ex160_IntersectioOfTwoLinkedLists {
    //暴力法

    //用时797ms，击败5.22%用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headB1=headB;
        ListNode temp=null;
        while(headA!=null){
            headB1=headB;
            while (headB1!=null){
                if(headB1==headA)return headB1;
                headB1=headB1.next;
            }
        }
       return null;
    }
}
