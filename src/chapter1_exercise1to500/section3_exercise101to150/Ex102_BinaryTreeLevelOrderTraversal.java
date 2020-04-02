package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*/
public class Ex102_BinaryTreeLevelOrderTraversal {
    //用时1ms  打败95%的提交
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        if(root==null)return result;
        List<Integer>temp=new ArrayList<>();
        temp.add(root.val);
        result.add(temp);
        List<TreeNode>roots=new ArrayList<>();
        roots.add(root.left);
        roots.add(root.right);
        if(roots.size()!=0)getLevelOrder(result,roots);
        return result;
    }
    //遍历本层节点，并且对本层节点的下一层节点进行递归遍历
    public void getLevelOrder(List<List<Integer>>result,List<TreeNode>roots){
        List<Integer>temp=new ArrayList<>();
        List<TreeNode>newRoots=new ArrayList<>();
        TreeNode tempNode=new TreeNode(1);
        for(int i=0;i<roots.size();i++){
            tempNode=roots.get(i);
            if(tempNode==null)continue;
            temp.add(tempNode.val);
            newRoots.add(tempNode.left);
            newRoots.add(tempNode.right);
        }
        if(temp.size()!=0){
            result.add(temp);
            if(newRoots.size()!=0)getLevelOrder(result,newRoots);
        }
    }
}

