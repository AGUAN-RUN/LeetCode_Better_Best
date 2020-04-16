package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.*;

/*Given a binary tree, return the postorder traversal of its nodes' values.*/
public class Ex145_BinaryTreePostorderTraversal_2 {
    //迭代方法
    //这个算法的本质是用栈的迭代，栈元素有规律的消减来模拟递归方法的过程

    //用时1ms
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        //用一个Map来记录某个节点是不是访问过
        Map<TreeNode,Boolean> isVisit=new HashMap<>();
        Stack stack=new Stack();
        stack.push(root);
        while(!stack.empty()){
            root=(TreeNode)stack.peek();
            if ((root.left == null||isVisit.get(root.left)!=null) &&(root.right == null||isVisit.get(root.right)!=null) ) {
               result.add(root.val);
               isVisit.put(root,true);
               stack.pop();
            }else {
                if(root.right!=null&&isVisit.get(root.right)==null)stack.push(root.right);
                if(root.left!=null&&isVisit.get(root.left)==null)stack.push(root.left);
            }
        }
        return result;
    }
}
