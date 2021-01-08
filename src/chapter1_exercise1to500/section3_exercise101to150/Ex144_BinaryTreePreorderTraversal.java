package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*Given a binary tree, return the preorder traversal of its nodes' values.
* Follow up: Recursive solution is trivial, could you do it iteratively?
* */
/*
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[1,2]
示例 5：


输入：root = [1,null,2]
输出：[1,2]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
 


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

