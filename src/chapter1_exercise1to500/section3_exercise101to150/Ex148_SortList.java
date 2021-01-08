package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;

import java.util.Arrays;

/*Sort a linked list in O(n log n) time using constant space complexity.*/
/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：

你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 

示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]
 

提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105


* */
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
