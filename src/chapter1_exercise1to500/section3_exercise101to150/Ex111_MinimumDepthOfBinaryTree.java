package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
*/
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
