package chapter1_exercise1to500.section4_exercise151to200;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。


* */
public class Ex189_RotateArray {
    //来个暴力的

    //0ms 击败100%
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)return;
        k=k%nums.length;
        if(k==0)return;
        int[]temp=new int [k];
        int st=0;
        for(int i=nums.length-k;i<nums.length;i++){
            temp[st++]=nums[i];
        }
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[i-k];
        }
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
    }
}
