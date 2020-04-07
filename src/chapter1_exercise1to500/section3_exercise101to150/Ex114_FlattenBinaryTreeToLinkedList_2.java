package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, flatten it to a linked list in-place.*/
public class Ex114_FlattenBinaryTreeToLinkedList_2 {
   //原来可以这样递归系列，别人家的代码
   public void flatten(TreeNode root) {
       if(root==null){
           return ;
       }
       flatten(root.left);
       flatten(root.right);
       TreeNode tmp = root.right;
       root.right = root.left;
       root.left = null;
       while(root.right!=null){
           root = root.right;
       }
       root.right = tmp;
   }

}