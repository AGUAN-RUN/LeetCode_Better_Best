package chapter1_exercise1to500.section5_exercese201to250;

import commons.ListNode;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
* */
public class Ex234_PalindromeLinkedList_3 {
    //在第二次提交的基础上略加改进
    //不使用额外空间  时间复杂度O(n)  空间复杂读O(1)  使用快慢指针算法 找到中点再反转后半部分链表进行比较

   //用时1ms  击败了99.82%
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode slow=head;
        ListNode fast=head;
        //快慢指针找链表中点
        //好多次了  用while 的地方写成了 if  太粗心了小兄弟
        /*if(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }*/
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //反转中点后的链表
        slow=reverseListNode(slow);
        //判断是否回文串
        while (head!=null&&slow!=null){
            if(head.val!=slow.val)return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }
    //[1,0,3,4,4,0,1]
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);

        listNode.next=new ListNode(0);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(0);
        listNode.next.next.next.next.next=new ListNode(1);

        Ex234_PalindromeLinkedList_3 test=new Ex234_PalindromeLinkedList_3();
        test.isPalindrome(listNode);
    }
}
