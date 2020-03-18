package chapter1_exercise1to500.section2_exercise51to100;

public class Ex83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode iterator=head;
        int value=head.val;
        while(iterator.next!=null){
            if(iterator.next.val==value){
                iterator.next=iterator.next.next;
            }else{
                value=iterator.next.val;
                iterator=iterator.next;
            }
        }
        return head;
    }

}
