package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

*/

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
