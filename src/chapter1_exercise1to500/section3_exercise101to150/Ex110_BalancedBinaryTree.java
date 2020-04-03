package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
*/
public class Ex110_BalancedBinaryTree {
    //1左右子树不是平衡二叉树，则该树不是平衡二叉树。如果左右子树高度相差超过1，该树不是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        ifTreeHightBalanced(root)
    }
    public int ifTreeHightBalanced(TreeNode root){

    }
}
