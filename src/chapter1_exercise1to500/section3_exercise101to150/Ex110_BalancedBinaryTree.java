package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
*/
public class Ex110_BalancedBinaryTree {
    //改造一下计算树高的方法，如果相差超过一，就返回-1;最后返回的结果是-1，则不是平衡二叉树

    //执行用时1ms，击败99%的提交
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int status=caculateBalancedBinaryTreeHight(root,0);
        if(status==-1)return false;
        return true;
    }
    public int caculateBalancedBinaryTreeHight(TreeNode root,int value){
        if(root==null)return value;
        int left = caculateBalancedBinaryTreeHight(root.left,value);
        if(left==-1)return -1;
        int right= caculateBalancedBinaryTreeHight(root.right,value);
        if(right==-1)return -1;
        if(left-right>1||left-right<-1){
            return -1;
        }else {
            return left>right?left+1:right+1;
        }
    }
}
