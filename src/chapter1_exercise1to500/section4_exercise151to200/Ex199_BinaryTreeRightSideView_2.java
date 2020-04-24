package chapter1_exercise1to500.section4_exercise151to200;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

* */
public class Ex199_BinaryTreeRightSideView_2 {
    List<Integer>result=new ArrayList<>();
    //深度优先搜索，先右节点，再左节点-->右节点的右节点......再右节点的左节......再左节点的右节点......再左节点的左节点......

    //用时1ms  击败97.32
    public List<Integer> rightSideView(TreeNode root) {
          if(root==null)return result;
          dfs(root,0);
          return result;
    }
    public void dfs(TreeNode root,int deep){
        if(deep==result.size())result.add(root.val);
        if(root.right!=null)dfs(root.right,deep+1);
        if(root.left!=null)dfs(root.left,deep+1);
    }
}










