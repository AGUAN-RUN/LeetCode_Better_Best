package chapter1.section1_99;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode iterator=head;
        while(iterator!=null&&iterator.next!=null){
            if(iterator.val==iterator.next.val){
                iterator.next=iterator.next.next;
            }else{
                iterator=iterator.next;
            }
        }
        return head;
    }
}