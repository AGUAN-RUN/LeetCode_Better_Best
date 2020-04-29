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
public class Ex236_LowestCommonAncestorOfABinaryTree {
    //时间复杂度   O(n^2)   leetcode测试用例运行时间超时了   优化
    Map<TreeNode, Set<Integer>>mapLeft=new HashMap<>();
    Map<TreeNode,Set<Integer>>mapRight=new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //使用两个Map 一个存储每个节点和该节点左边包含的所有元素的映射，一个储存每节点和节点右边包含的所有的元素的映射
        getTreeNodeLeftSetAndRightSet(root,mapLeft,mapRight);
        return lowestCommonAncestorWorker(root,p,q);
    }
    public TreeNode lowestCommonAncestorWorker(TreeNode root,TreeNode p,TreeNode q){
        Set<Integer>left=mapLeft.get(root);
        Set<Integer>right=mapRight.get(root);
        if(left.contains(p.val)&&left.contains(q.val)){
            return lowestCommonAncestorWorker(root.left,p,q);
        }else if(right.contains(p.val)&&right.contains(q.val)){
            return lowestCommonAncestorWorker(root.right,p,q);
        }
        return root;
    }
    public void getTreeNodeLeftSetAndRightSet(TreeNode root,Map<TreeNode, Set<Integer>>mapLeft,Map<TreeNode, Set<Integer>>mapRight){
        Set<Integer>setLeft=new HashSet<>();
        Set<Integer>setRight=new HashSet<>();
        if(root.left!=null){
            getTreeNodeLeftSetAndRightSet(root.left,mapLeft,mapRight);
            setLeft.addAll(mapLeft.get(root.left));
            setLeft.addAll(mapRight.get(root.left));
            setLeft.add(root.left.val);
        }
        mapLeft.put(root,setLeft);
        if(root.right!=null){
            getTreeNodeLeftSetAndRightSet(root.right,mapLeft,mapRight);
            setRight.addAll(mapLeft.get(root.right));
            setRight.addAll(mapRight.get(root.right));
            setRight.add(root.right.val);
        }
        mapRight.put(root,setRight);
    }
}
