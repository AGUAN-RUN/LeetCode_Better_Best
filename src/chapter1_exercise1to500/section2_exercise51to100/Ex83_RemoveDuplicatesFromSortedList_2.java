package chapter1_exercise1to500.section2_exercise51to100;

public class Ex83_RemoveDuplicatesFromSortedList_2 {
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