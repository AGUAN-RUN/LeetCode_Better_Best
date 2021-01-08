package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的遍历顺序：前序遍历（根节点在左右节点前遍历）  中左右     中序遍历（根节点在"左右节点中遍历） 左中右      后序遍历（根节点在遍历完左右节点后再遍历） 左右中
/*
给定一个二叉树的根节点 root ，返回它的 中序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
 

进阶: 递归算法很简单，你可以通过迭代算法完成吗？


* */
class Ex94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //使用递归算法进行遍历
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        inorderTraversaWork(root,result);
        return result;
    }
    public void inorderTraversaWork(TreeNode root, List<Integer>result){
        if(root.left!=null)inorderTraversaWork(root.left,result);
        result.add(root.val);
        if(root.right!=null)inorderTraversaWork(root.right,result);
    }
}