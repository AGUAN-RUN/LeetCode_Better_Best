package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的遍历顺序：前序遍历（根节点在左右节点前遍历）  中左右     中序遍历（根节点在"左右节点中遍历） 左中右      后序遍历（根节点在遍历完左右节点后再遍历） 左右中
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