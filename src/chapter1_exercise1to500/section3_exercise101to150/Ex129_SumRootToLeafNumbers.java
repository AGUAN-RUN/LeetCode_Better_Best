package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*
*
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
*/

/*
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.


* */
public class Ex129_SumRootToLeafNumbers {
    //测试用例时间0ms ，击败100%
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return sumNumbersWorker(root,root.val);
    }
    public int sumNumbersWorker(TreeNode root,int val) {
        if(root.right==null&&root.left==null)return val;
        int base=val*10;
        if(root.left==null)return sumNumbersWorker(root.right,base+root.right.val);
        if(root.right==null)return sumNumbersWorker(root.left,base+root.left.val);
        return sumNumbersWorker(root.left,base+root.left.val)+sumNumbersWorker(root.right,base+root.right.val);
    }
}
