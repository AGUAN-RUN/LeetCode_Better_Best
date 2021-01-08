package chapter1_exercise1to500.section2_exercise51to100;
/*给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。*/
/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL


* */
public class Ex61_RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        if(head.next==null)return head;
        //先计算链表长度,拿到尾节点
        ListNode head2=head;
        int length=1;
        while(head2.next!=null){
            head2=head2.next;
            length++;
        }
        //计算实际前移个数
        k=k%length;
        if(k==0)return head;
        int end=length-k;
        ListNode endNode=head;
        while(end>1){
            endNode=endNode.next;
            end--;
        }
        head2.next=head;
        ListNode result=endNode.next;
        endNode.next=null;
        return result;
    }
}
