package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*Given a binary tree, return the postorder traversal of its nodes' values.*/

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
