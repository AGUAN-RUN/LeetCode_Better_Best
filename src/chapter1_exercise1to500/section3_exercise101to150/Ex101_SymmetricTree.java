package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
*/
/*
给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 

进阶：

你可以运用递归和迭代两种方法解决这个问题吗？


* */
public class Ex101_SymmetricTree{
    //1ms 击败45%
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        if(root.left==null&&root.right==null)return true;
        if(root.left==null||root.right==null)return false;
        if(root.left.val!=root.right.val)return false;
        return isTreeSymmetric(root.left,root.right);
    }
    public boolean isTreeSymmetric(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null)return true;
        if(node1==null||node2==null)return false;
        if(node1.val!=node2.val)return false;
        return isTreeSymmetric(node1.left,node2.right)&&isTreeSymmetric(node1.right,node2.left);
    }
}
