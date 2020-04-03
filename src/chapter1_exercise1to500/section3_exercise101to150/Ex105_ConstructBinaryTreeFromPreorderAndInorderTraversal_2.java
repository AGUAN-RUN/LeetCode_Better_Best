package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given preorder and inorder traversal of a tree, construct the binary tree.
* You may assume that duplicates do not exist in the tree.*/
public class Ex105_ConstructBinaryTreeFromPreorderAndInorderTraversal_2 {
   //尝试不使用这么多指针求解
    //当数组中的数都小于Integer.MAX_VALUE时，可用下法
    //下算法参考了执行用时1ms  击败100%算法的思路
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int stop=Integer.MAX_VALUE;
        return buildTreeWorker(preorder,inorder,stop);
    }
    int m=0 ;
    int n=0;
    public TreeNode buildTreeWorker(int[]preorder,int[]inorder,int val){
        if(preorder.length==m){
            return null;
        }
        if(inorder[n]==val) {
            n++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[m++]);
        //inorder的第n个数为当前节点值，则该节点没有左节点
        root.left=buildTreeWorker(preorder,inorder,root.val);
        //inorder的第n个数为传入的父节点值，则该节点没有右节点
        root.right=buildTreeWorker(preorder,inorder,val);
        return root;
    }
}
