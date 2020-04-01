package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

/*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*/
public class Ex100_SameTree{
    //递归
    //0ms,击败100%
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if(p==null||q==null){
            if(p==q)return true;
            return false;
         }
         if(p.val!=q.val)return false;
         return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
