package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ex94_BinaryTreeInorderTraversal_2 {
    //迭代算法，使用栈辅助
    public List<Integer> inorderTraversal(TreeNode root) {
        //使用递归算法进行遍历
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Stack<TreeNode>res=new Stack<>();
        while(root!=null||!res.empty()){
            while(root!=null){
                res.push(root);
                root=root.left;
            }
            root=res.pop();
            result.add(root.val);
            root=root.left;
        }
        return result;
    }
}
