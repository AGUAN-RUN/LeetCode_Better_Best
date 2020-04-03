package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;
import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1

*/
public class Ex109_ConvertSortedListToBinarySearchTree_2 {
    //如果copy则毫无意义，浪费时间，浪费时间，欺骗自己，欺骗他人，百害无一利.
    //至少理解主要思路，设计重写

    //快慢指针找链表中点的算法
    //快慢指针法，指针一一次走一步，指针二一次走两步，当指针二走到一个空的位置，指针二的下一个位置就是'中点'（链表元素为奇数个时）或两个中点中的一个（这里是两个中点右边的那个）（链表元素为偶数个时）
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null||head.next==null){
            return head==null?null:new TreeNode(head.val);
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        fast=slow.next;
        //断链
        pre.next=null;
        TreeNode node = new TreeNode(slow.val);
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(fast);
        return node;
    }
}
