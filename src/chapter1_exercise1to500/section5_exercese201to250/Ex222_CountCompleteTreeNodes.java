package chapter1_exercise1to500.section5_exercese201to250;

import commons.TreeNode;

/*
Given a complete binary tree, count the number of nodes.

Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/
public class Ex222_CountCompleteTreeNodes {
    //如果直接BFS遍历整棵树可以得到 该树的节点数量，但是其实并不需要遍历整颗树也可以计算出节点数量
    //获得二叉树的高度h以及缺失的叶子节点m   2^h-1-m  为该满二叉树的节点数量

    //暴力递归计算  时间复杂度 O(n)
    //Oms  击败100% 测试用例不够科学  不应该击败100%
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}
