package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

/*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*/

/*
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false


* */
public class Ex100_SameTree{
    //递归
    //0ms,击败100%
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null||q==null){
            if(p==q)return true;
            return false;
         }
         if(p.val!=q.val)return false;
         return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
