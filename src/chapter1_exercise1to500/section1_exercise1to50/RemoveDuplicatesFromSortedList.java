package chapter1_exercise1to500.section1_exercise1to50;

public class RemoveDuplicatesFromSortedList {
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
