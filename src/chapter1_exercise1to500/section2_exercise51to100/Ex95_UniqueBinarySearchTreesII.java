package chapter1_exercise1to500.section2_exercise51to100;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
*/
public class Ex95_UniqueBinarySearchTreesII {
    //迭代+递归求解，子问题分解
    //考虑程序的鲁棒性（鲁棒是Robust的音译，也就是健壮和强壮的意思。它也是在异常和危险情况下系统生存的能力。），最后考虑特殊极端输入



    //得到左子树集合，得到右子树集合,嵌套遍历出结果
    //用时2ms   击败85%
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>result=new ArrayList<>();
        if(n<=0)return result;
        if(n==1){
            TreeNode node=new TreeNode(1);
            result.add(node);
            return result;
        }
        int[]nums=new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=i+1;
        }
        for(int i=0;i<nums.length;i++){
            List<TreeNode> leftNodes=generateTreeNode(nums,0,i);
            List<TreeNode> rightNodes=generateTreeNode(nums,i+1,nums.length);
            if(leftNodes.size()==0){
                for(int k=0;k<rightNodes.size();k++){
                    TreeNode treeNode=new TreeNode(nums[i]);
                    treeNode.right=rightNodes.get(k);
                    result.add(treeNode);
                }
            }else if(rightNodes.size()==0){
                for(int k=0;k<leftNodes.size();k++){
                    TreeNode treeNode=new TreeNode(nums[i]);
                    treeNode.left=leftNodes.get(k);
                    result.add(treeNode);
                }
            }else {
                for (int j = 0; j < leftNodes.size(); j++) {
                    TreeNode leftNode=leftNodes.get(j);
                    for (int k = 0; k < rightNodes.size(); k++) {
                        TreeNode treeNode=new TreeNode(nums[i]);
                        treeNode.left = leftNode;
                        treeNode.right=rightNodes.get(k);
                        result.add(treeNode);
                    }
                }
            }
        }
        return result;
    }
    public List<TreeNode> generateTreeNode(int [] nums,int m,int n){
        List<TreeNode>result=new ArrayList<>();
        if(n<=m)return result;
        if(n==m+1){
            result.add(new TreeNode(nums[m]));
            return result;
        }
        for(int i=m;i<n;i++){
            List<TreeNode> leftNodes=generateTreeNode(nums,m,i);
            List<TreeNode> rightNodes=generateTreeNode(nums,i+1,n);
            if(leftNodes.size()==0){
                for(int k=0;k<rightNodes.size();k++){
                    TreeNode treeNode=new TreeNode(nums[i]);
                    treeNode.right=rightNodes.get(k);
                    result.add(treeNode);
                }
            }else if(rightNodes.size()==0){
                for(int k=0;k<leftNodes.size();k++){
                    TreeNode treeNode=new TreeNode(nums[i]);
                    treeNode.left=leftNodes.get(k);
                    result.add(treeNode);
                }
            }else {
                for (int j = 0; j < leftNodes.size(); j++) {
                    TreeNode leftNode=leftNodes.get(j);
                    for (int k = 0; k < rightNodes.size(); k++) {
                        TreeNode treeNode=new TreeNode(nums[i]);
                        treeNode.left = leftNode;
                        treeNode.right=rightNodes.get(k);
                        result.add(treeNode);
                    }
                }
            }
        }
        return result;
    }

}
