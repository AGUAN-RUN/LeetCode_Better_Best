package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given a binary tree, return the preorder traversal of its nodes' values.
* Follow up: Recursive solution is trivial, could you do it iteratively?
* */
public class Ex144_BinaryTreePreorderTraversal_2 {
    //迭代方法
    //1ms  比递归慢
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack stack=new Stack();
        stack.push(root);
        //stack.push();
        //stack.pop();
        while (!stack.empty()){
           TreeNode temp=(TreeNode) stack.pop();
           if(temp!=null) {
               result.add(temp.val);
               stack.push(temp.right);
               stack.push(temp.left);
           }
        }
        return result;
    }
}
