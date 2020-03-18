package chapter1_exercise1to500.section1_exercise1to50;

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