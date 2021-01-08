package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
*/

/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 

提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000


* */
public class Ex111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        List<TreeNode>nodes=new ArrayList<>();
        nodes.add(root);
        return caculateMinDepth(nodes,1);
    }
    public int caculateMinDepth(List<TreeNode> nodes, int deep){
        List<TreeNode>next=new ArrayList<>();
        TreeNode temp=null;
        for(int i=0;i<nodes.size();i++){
            temp=nodes.get(i);
            if(temp.left==null&&temp.right==null)return deep;
            if(temp.left!=null)next.add(temp.left);
            if(temp.right!=null)next.add(temp.right);
        }
        return caculateMinDepth(next,deep+1);
    }
}
