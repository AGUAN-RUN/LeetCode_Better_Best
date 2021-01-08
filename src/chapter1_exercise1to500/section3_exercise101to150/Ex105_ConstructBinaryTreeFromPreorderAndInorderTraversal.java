package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;
import sun.reflect.generics.tree.Tree;

/*Given preorder and inorder traversal of a tree, construct the binary tree.
* You may assume that duplicates do not exist in the tree.*/

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


* */
public class Ex105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //单单从一个二叉树的前中或后序排序中，不能唯一还原成的原来的树，因为这个排序可能可以构造出多个不同的树 如 [4，5，6，8]
    //二叉搜索树同上

    //递归构造树
    //用时5ms ， 击败50%    尝试改进
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0||inorder==null||inorder.length==0||preorder.length!=inorder.length)return null;
        TreeNode result=new TreeNode(preorder[0]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                if(i!=0)result.left=buildTreeWorker(preorder,1,i,inorder,0,i-1);
                if(i!=inorder.length-1)result.right=buildTreeWorker(preorder,i+1,preorder.length-1,inorder,i+1,inorder.length-1);
                break;
            }
        }
        return result;
    }
    public TreeNode buildTreeWorker(int[]preorder,int a,int b,int [] inorder,int c,int d){
        TreeNode result=new TreeNode(preorder[a]);
        if(a==b)return result;
        for(int i=c;i<=d;i++){
            if(inorder[i]==preorder[a]) {
                int leftCount=i-c;
                if(leftCount!=0)result.left = buildTreeWorker(preorder,a+1,a+leftCount,inorder,c,i-1);
                int rightCount=d-i;
                if(rightCount!=0)result.right=buildTreeWorker(preorder,a+leftCount+1,b,inorder,i+1,d);
                break;
            }
        }
        return result;
    }
}
