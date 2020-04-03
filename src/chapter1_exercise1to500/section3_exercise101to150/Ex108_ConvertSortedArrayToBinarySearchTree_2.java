package chapter1_exercise1to500.section3_exercise101to150;

import commons.TreeNode;

/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1
*/
public class Ex108_ConvertSortedArrayToBinarySearchTree_2 {
    //使用双指针,递归构造左右子树
    //用时0ms，击败100%的用户
    //开始优化：sortedArrayToBST方法只是调用方法，把具体实现都放到sortedArrayToBSTBuild，让方法sortedArrayToBSTBuild复用性更强
    public TreeNode sortedArrayToBST(int[] nums) {
            if(nums==null||nums.length==0)return null;
            return sortedArrayToBSTBuild(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBSTBuild(int [] nums,int begin,int end){
        if(end==begin)return new TreeNode(nums[begin]);
        int mid=(begin+end)/2;
        TreeNode result=new TreeNode(nums[mid]);
        if(mid>begin)result.left=sortedArrayToBSTBuild(nums,begin,mid-1);
        if(mid<end)result.right=sortedArrayToBSTBuild(nums,mid+1,end);
        return  result;
    }
}
