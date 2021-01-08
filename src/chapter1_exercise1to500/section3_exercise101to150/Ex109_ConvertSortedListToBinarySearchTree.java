package chapter1_exercise1to500.section3_exercise101to150;

import commons.ListNode;
import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1

*/

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5


* */
public class Ex109_ConvertSortedListToBinarySearchTree {
    //先把链表转化为数组，然后求解起来就很简单，可以使用java的动态数组来装载链表元素

    //用时2ms，击败31%  此算法对于很长的链表效率要优于使用三指针（快慢指针法）不断寻找链表的中点然后再断链递归的效率高，击败太少测试用例太少链表过短
    //快慢指针法，指针一一次走一步，指针二一次走两步，当指针二走到一个空的位置，指针二的下一个位置就是'中点'（链表元素为奇数个时）或两个中点中的一个（链表元素为偶数个时）
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
