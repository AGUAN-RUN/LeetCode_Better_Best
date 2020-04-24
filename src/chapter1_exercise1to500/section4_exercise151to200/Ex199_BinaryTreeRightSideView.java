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
public class Ex199_BinaryTreeRightSideView {
    //先来个广度优先搜索  把节点从上到下从左到右遍历并放到列表中 然后取每一个列表最后的节点值  放入结果集中

    //用时2ms  击败34%的java提交
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer>result=new ArrayList<>();
         if(root==null)return result;
         List<List<TreeNode>>BFSRoots=new ArrayList<>();
         List<TreeNode>roots=new ArrayList<>();
         roots.add(root);
         BFSRoots.add(roots);
         completeBFSTreeNodeList(BFSRoots);
         for(List<TreeNode>a:BFSRoots){
             result.add(a.get(a.size()-1).val);
         }
         return result;
    }
    public void completeBFSTreeNodeList(List<List<TreeNode>>BFSRoots){
         List<TreeNode>preRoots=BFSRoots.get(BFSRoots.size()-1);
         List<TreeNode>newRoots=new ArrayList<>();
         for(TreeNode a:preRoots){
             if(a==null)continue;
             if(a.left!=null)newRoots.add(a.left);
             if(a.right!=null)newRoots.add(a.right);
         }
         if(newRoots.size()==0)return;
         BFSRoots.add(newRoots);
         completeBFSTreeNodeList(BFSRoots);
    }
}










