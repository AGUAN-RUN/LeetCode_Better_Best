package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;
/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
* and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807


 */


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
