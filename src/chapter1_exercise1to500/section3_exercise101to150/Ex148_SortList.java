package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

import java.util.Arrays;

/*Sort a linked list in O(n log n) time using constant space complexity.*/
public class Ex148_SortList {
    //数组保值排序再刷新节点值

    //用时3ms 击败99.27的用户
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int[]nums=new int [length];
        length=0;
        temp=head;
        while(temp!=null){
            nums[length++]=temp.val;
            temp=temp.next;
        }
        Arrays.sort(nums);
        temp=head;
        for(int i=0;i<nums.length;i++){
            temp.val=nums[i];
            temp=temp.next;
        }
        return head;
    }
}
