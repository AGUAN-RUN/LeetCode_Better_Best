package chapter1_exercise1to500.section5_exercese201to250;

import commons.TreeNode;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
* */
public class Ex226_InvertBinaryTree {
    //递归简单算法

    //0ms  击败100%
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode temp=invertTree(root.left);
            root.left=invertTree(root.right);
            root.right=temp;
        }
        return root;
    }
}
