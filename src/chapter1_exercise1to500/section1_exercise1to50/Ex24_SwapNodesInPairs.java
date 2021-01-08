package chapter1_exercise1to500.section1_exercise1to50;

import commons.ListNode;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100


* */
public class Ex24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;
        while(p.next != null && p.next.next != null) {
            ListNode node1 = p.next, node2 = p.next.next, next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummy.next;
    }
}
