package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

*/

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]


* */

public class Ex113_PathSumII {
    //2ms  击败66%
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>result =new ArrayList<>();
        if(root==null)return result;
        List<Integer>temp=new ArrayList<>();
        temp.add(root.val);
        getAllPathSum(result,temp,root,sum);
        return result;
    }
    public void getAllPathSum(List<List<Integer>>result,List<Integer>temp,TreeNode node,int sum){
      //由于有负数到存在，所有节点叠加过程中只要还没遍历到叶子节点，和可以比sum大，因为后面可以添加值为负数的子节点
      /* if(node.val>sum)return;*/
       if(node.left==null&&node.right==null){
           if(node.val==sum)result.add(new ArrayList<>(temp));
           else return;
       }
       if(node.left!=null){
           temp.add(node.left.val);
           getAllPathSum(result,temp,node.left,sum-node.val);
           temp.remove(temp.size()-1);
       }
       if(node.right!=null){
           temp.add(node.right.val);
           getAllPathSum(result,temp,node.right,sum-node.val);
           temp.remove(temp.size()-1);
       }
       return;
    }
}
