package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
public class Ex104_MaximumDepthOfBinaryTree {
    //递归返回左右字数最大深度加一

    //执行用时 “0ms”  击败100%
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int maxLeft=maxDepth(root.left)+1;
        int maxRight=maxDepth(root.right)+1;
        return maxLeft=maxRight>maxLeft?maxRight:maxLeft;
    }
}
