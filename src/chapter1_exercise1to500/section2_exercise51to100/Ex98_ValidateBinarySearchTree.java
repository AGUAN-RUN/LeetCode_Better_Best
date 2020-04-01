package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/
public class Ex98_ValidateBinarySearchTree {
    //先使用中序遍历保存 树的节点值到list中，如果是该树是二叉查找树，则list中的数据一定是升序排序的

    //用时4ms 击败13% 有待优化。
    //优化思路： 先对树进行中序遍历，再判断不如一边遍历一边判断，发现不满足二叉查找树性质，立刻返回false，不再继续画蛇添足，可以提升效率。
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        List<Integer>trees=new ArrayList<>();
        middleTraversal(root,trees);
        if(trees.size()<2)return true;
        for(int i=1;i<trees.size();i++){
            if(trees.get(i)<trees.get(i-1))return false;
        }
        return true;
    }
    public void middleTraversal(TreeNode root,List<Integer>result){
        if(root.left!=null)middleTraversal(root.left,result);
        result.add(root.val);
        if(root.right!=null)middleTraversal(root.right,result);
    }
}
