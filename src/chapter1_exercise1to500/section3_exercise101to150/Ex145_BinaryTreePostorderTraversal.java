package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*Given a binary tree, return the postorder traversal of its nodes' values.*/
/*
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？


* */

public class Ex145_BinaryTreePostorderTraversal {
    //递归方法
    //用时0ms  击败100%的用户
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer>result=new ArrayList<>();
       postorderTraversalWorker(root,result);
       return result;
    }
    public void postorderTraversalWorker(TreeNode root,List<Integer>result){
        if(root==null)return;
        postorderTraversalWorker(root.left,result);
        postorderTraversalWorker(root.right,result);
        result.add(root.val);
    }
}
