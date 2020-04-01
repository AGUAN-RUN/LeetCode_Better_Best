package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/
public class Ex98_ValidateBinarySearchTree_2 {
    //错误，反思，总结，提升
    //特殊输入，极限输入，鲁棒性
    //优化思路： 先对树进行中序遍历，再判断不如一边遍历一边判断，发现不满足二叉查找树性质，立刻返回false，不再继续画蛇添足，可以提升效率。
    public boolean isValidBST(TreeNode root) {
        //使用long的最大（最小值），TreeNode的值为int，long的最小（最大值）比int更小（大），以免输入root中有节点值为int的最小最大值，导致误判
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        if(root==null)return true;
        return isValidBSTWorker(root.left,min,(long)root.val)&&isValidBSTWorker(root.right,(long)root.val,max);
    }
    public boolean isValidBSTWorker(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }if((long)root.val<=min||(long)root.val>=max){
            return false;
        }else {
            return isValidBSTWorker(root.left,min,(long)root.val)&&isValidBSTWorker(root.right,(long)root.val,max);
        }
    }
}
