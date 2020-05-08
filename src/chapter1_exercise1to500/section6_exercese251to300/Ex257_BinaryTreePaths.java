package chapter1_exercise1to500.section6_exercese251to300;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
* */
public class Ex257_BinaryTreePaths {
    //2ms  击败了88.14%
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList<>();
        if(root==null)return result;
        StringBuilder sb=new StringBuilder().append(root.val);
        collectBinaryTreePathsToList(root,sb,result);
        return result;
    }
    public void collectBinaryTreePathsToList(TreeNode root,StringBuilder sb,List<String>result){
        if(root.left==null&&root.right==null){
            result.add(sb.toString());
        }
        if(root.left!=null){
            collectBinaryTreePathsToList(root.left,new StringBuilder(sb).append("->").append(root.left.val),result);
        }
        if(root.right!=null){
            collectBinaryTreePathsToList(root.right,new StringBuilder(sb).append("->").append(root.right.val),result);
        }
    }
}
