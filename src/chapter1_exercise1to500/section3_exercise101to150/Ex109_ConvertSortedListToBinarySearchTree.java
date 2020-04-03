package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;
import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1

*/
public class Ex109_ConvertSortedListToBinarySearchTree {
    //先把链表转化为数组，然后求解起来就很简单，可以使用java的动态数组来装载链表元素

    //用时2ms，击败31%
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        List<Integer>nums=new ArrayList<>();
        while (head!=null){
           nums.add(head.val);
           head=head.next;
       }
        return  sortedListToBSTBuild(nums,0,nums.size()-1);
    }
    public TreeNode sortedListToBSTBuild(List<Integer>nums,int begin,int end){
        if(begin==end)return new TreeNode(nums.get(begin));
        int mid=(begin+end)/2;
        TreeNode node=new TreeNode(nums.get(mid));
        if(mid>begin)node.left=sortedListToBSTBuild(nums,begin,mid-1);
        if(mid<end)node.right=sortedListToBSTBuild(nums,mid+1,end);
        return node;
    }
}
