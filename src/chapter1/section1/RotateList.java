package chapter1.section1;
/*给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。*/
public class RotateList {
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
