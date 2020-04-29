package chapter1_exercise1to500.section5_exercese201to250;

import commons.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
* */
public class Ex236_LowestCommonAncestorOfABinaryTree_2 {
    //优化  时间空间复杂度都是O(n)

    //用时6ms  击败99.81%
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorWorker(root,p,q);
        return result;
    }
    public boolean lowestCommonAncestorWorker(TreeNode root,TreeNode p,TreeNode q){

        if(root==null)return false;
       boolean mid=root.val==p.val||root.val==q.val;
       boolean left=lowestCommonAncestorWorker(root.left,p,q);
       if(result!=null)return false;
       if(mid&&left){
           result=root;
           return false;
       }
       boolean right=lowestCommonAncestorWorker(root.right,p,q);
       if(result!=null)return false;
       if((mid&&right)||(left&&right)){
           result=root;
           return false;
        }
       return left||mid||right;
    }
}
