package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
//参考了105题的思路设计的算法
//用时1ms，击败100%
public class Ex106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int m;
    int n;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        m=postorder.length-1;
        n=inorder.length-1;
        int stop=Integer.MAX_VALUE;
        return buildTreeWork(inorder,postorder,stop);
    }

    public TreeNode buildTreeWork(int[]inorder,int[]postorder,int stop){
        if(m<0){
            return null;
        }
        if(inorder[n]==stop){
            n--;
            return null;
        }
        TreeNode root=new TreeNode(postorder[m--]);
        //如果inorder[n]和当前节点值相等，则当前节点没有右节点
        root.right=buildTreeWork(inorder,postorder,root.val);
        //如果inorder[n]和传入值相同，则当前节点没有左节点
        //传入值为向上遍历第一个左边的父节点，如果没有这样的父节点，则传入值为初始值，这个节点也是最左边的节点，亦是中序（后序）排序数组中的第一个数
        root.left=buildTreeWork(inorder,postorder,stop);
        return root;
    }
}
