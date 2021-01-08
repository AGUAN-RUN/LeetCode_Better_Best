package chapter1_exercise1to500.section5_exercese201to250;

import commons.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?
* */
/*
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？


* */
public class Ex230_KthSmallestElementInABST {
    //用栈来实现此算法

    //用时0ms  击败100%
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        //每一层的最左边元素入栈
        while(root!=null){
            stack.addLast(root);
            root=root.left;
        }
        while (k>1){
            //由小到大的删节点
            TreeNode temp=stack.pollLast();
            k--;
            if(temp.right!=null){
                stack.addLast(temp.right);
                temp=temp.right;
                while (temp.left!=null){
                    stack.addLast(temp.left);
                    temp=temp.left;
                }
            }
        }
        return stack.peekLast().val;
    }
}
