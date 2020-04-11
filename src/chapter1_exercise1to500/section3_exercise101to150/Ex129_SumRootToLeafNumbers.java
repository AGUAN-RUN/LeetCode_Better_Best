package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*
*
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
*/
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
