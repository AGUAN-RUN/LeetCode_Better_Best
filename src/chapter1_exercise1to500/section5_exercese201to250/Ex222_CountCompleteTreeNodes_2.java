package chapter1_exercise1to500.section5_exercese201to250;

import commons.TreeNode;
import sun.reflect.generics.tree.Tree;

/*
Given a complete binary tree, count the number of nodes.

Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/
public class Ex222_CountCompleteTreeNodes_2 {

    //性质1：获得二叉树的高度h  h-1以及以上节点数量加上高度h的节点数量为该满二叉树的节点数量
    //性质2：左子树叶子节点不满，右子树叶子节点坑定也不满，左子树叶子节点满，右子树叶子节点不一定满

    //binary search   时间复杂度  O(lg^2n)   深度lgn  比较此时最多O（lgn）

    //用时0ms 击败100%
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        //最左边的节点高度树的高度
        int hightLt=0;
        TreeNode temp =root;
        while(temp!=null){
            temp=temp.left;
            hightLt++;
        }
        //计算倒数第二层及以上的节点数目
        int result=(int)Math.pow(2,hightLt-1)-1;
        //加上所有叶子节点的数目
        return  result+getLeefNodeNums(root.left,root.right);
    }
    public int getLeefNodeNums(TreeNode ltRoot,TreeNode rtRoot){
        //左左
        int sum=0;
        int ll=0;
        TreeNode temp=ltRoot;
        while(temp!=null){
            temp=temp.left;
            ll++;
        }
        //左右
        int lr=0;
        temp=ltRoot;
        while(temp!=null){
            temp=temp.right;
            lr++;
        }
        if(ll==0){
            return 0;
        }else if(ll==lr){
            sum+=Math.pow(2,ll-1);
            //右左
            temp=rtRoot;
            int rl=0;
            while(temp!=null){
                temp=temp.left;
                rl++;
            }
            if(rl<ll)return sum;
            //右右
            temp=rtRoot;
            int rr=0;
            while(temp!=null){
                temp=temp.right;
                rr++;
            }
            if(rr==ll){
                return 2*sum;
            }else {
                return sum+getLeefNodeNums(rtRoot.left,rtRoot.right);
            }
        }else {
            //ll!=lr  那么右节点最小一层没有节点
            return  getLeefNodeNums(ltRoot.left,ltRoot.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        Ex222_CountCompleteTreeNodes_2 test=new Ex222_CountCompleteTreeNodes_2();
        test.countNodes(root);
    }

}
