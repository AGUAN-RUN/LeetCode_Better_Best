package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.
。*/

/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。


* */
public class Ex112_PathSum {
    //不使用MAP等容器，直接改变树的子节点的值来计算从跟到叶子的加总

    //击败100%
    public boolean hasPathSum(TreeNode root, int sum) {
        //注意第一个root可能是null
        if(root==null)return false;
        if(root.right==null&&root.left==null){
            if(root.val==sum)return true;
            return false;
        }
        if(root.left!=null){
            root.left.val=root.left.val+root.val;
            if(hasPathSum(root.left,sum))return true;
        }
        if(root.right!=null){
            root.right.val=root.right.val+root.val;
            if(hasPathSum(root.right,sum))return true;
        }
        return false;
    }
}
