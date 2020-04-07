package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.
。*/
public class Ex112_PathSum {
    //不使用MAP等容器，直接改变树的子节点的值来计算从跟到叶子的加总
    public boolean hasPathSum(TreeNode root, int sum) {
        //注意第一个root可能是null
        if(root==null)return false;
        if(root.right==null&&root.left==null){
            if(root.val==sum)return true;
            return false;
        }
        if(root.left!=null){
            root.left.val=root.left.val+root.val;
            if(hasPathSum(root.left,sum))return true;
        }
        if(root.right!=null){
            root.right.val=root.right.val+root.val;
            if(hasPathSum(root.right,sum))return true;
        }
        return false;
    }
}
