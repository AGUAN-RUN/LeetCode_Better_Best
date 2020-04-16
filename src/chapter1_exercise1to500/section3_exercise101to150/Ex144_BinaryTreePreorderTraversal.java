package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*Given a binary tree, return the preorder traversal of its nodes' values.
* Follow up: Recursive solution is trivial, could you do it iteratively?
* */
public class Ex144_BinaryTreePreorderTraversal {
    //递归方法

    //用时0ms  击败100%的用户
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        preorderTraversalWorker(root,result);
        return result;
    }
    public void preorderTraversalWorker(TreeNode root,List<Integer>result){
        if(root==null)return;
        result.add(root.val);
        preorderTraversalWorker(root.left,result);
        preorderTraversalWorker(root.right,result);
    }
}

