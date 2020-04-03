package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
*/
public class Ex107_BinaryTreeLevelOrderTraversalII {
    //先从上到下从左到右遍历，再返回这个结果List的逆序
    //1ms 击败99%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>res1=new ArrayList<>();
        if(root==null)return res1;
        List<Integer>roots=new ArrayList<>();
        roots.add(root.val);
        res1.add(roots);
        List<TreeNode>temp=new ArrayList<>();
        temp.add(root.left);
        temp.add(root.right);
        levelOrderBottomExecuter(res1,temp);
        if(res1.size()<2)return res1;
        List<List<Integer>>res2=new ArrayList<>();
        for(int i=res1.size()-1;i>=0;i--){
            res2.add(res1.get(i));
        }
        return res2;
    }
    public void levelOrderBottomExecuter(List<List<Integer>>result,List<TreeNode>temp){
        List<TreeNode>nextRoots=new ArrayList<>();
        List<Integer>roots=new ArrayList<>();
        TreeNode tempRoot=new TreeNode(-1);
        for(int i=0;i<temp.size();i++){
            tempRoot=temp.get(i);
            if(tempRoot==null)continue;
            roots.add(tempRoot.val);
            nextRoots.add(tempRoot.left);
            nextRoots.add(tempRoot.right);
        }
        if(roots.size()!=0) {
            result.add(roots);
            levelOrderBottomExecuter(result,nextRoots);
        }
    }
}
