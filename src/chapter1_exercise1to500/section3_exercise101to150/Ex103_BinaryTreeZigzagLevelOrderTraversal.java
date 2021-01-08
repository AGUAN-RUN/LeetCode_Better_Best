package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
*/

/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]


* */
public class Ex103_BinaryTreeZigzagLevelOrderTraversal {
    //在102题的基础上，增加一个反转的标志位即可，不同的标志位用不同的顺序遍历。遍历完一层后，就改变标志位
    //1ms 击败98%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        if(root==null)return result;
        List<Integer>temp=new ArrayList<>();
        temp.add(root.val);
        result.add(temp);
        List<TreeNode>roots=new ArrayList<>();
        roots.add(root.left);
        roots.add(root.right);
        getZigzagLevelOrder(result,roots,-1);
        return result;
    }
    public void getZigzagLevelOrder(List<List<Integer>>result,List<TreeNode>roots,int flag){
        List<Integer>temp=new ArrayList<>();
        List<TreeNode>nextRoots=new ArrayList<>();
        TreeNode tempRoot=new TreeNode(-1);
        if(flag==-1){
            for(int i=roots.size()-1;i>=0;i--){
                tempRoot=roots.get(i);
                if(tempRoot==null)continue;
                temp.add(tempRoot.val);
                nextRoots.add(tempRoot.right);
                nextRoots.add(tempRoot.left);
            }
        }else{
            for(int i=roots.size()-1;i>=0;i--){
                tempRoot=roots.get(i);
                if(tempRoot==null)continue;
                temp.add(tempRoot.val);
                nextRoots.add(tempRoot.left);
                nextRoots.add(tempRoot.right);
            }
        }
        flag=flag*-1;
        if(temp.size()!=0){
            result.add(temp);
            if(nextRoots.size()!=0)getZigzagLevelOrder(result,nextRoots,flag);
        }
    }
}
