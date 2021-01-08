package chapter1_exercise1to500.section4_exercise151to200;
/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


* */
public class Ex152_MaximumProductSubarray {
    //暴力算法 O(n^2)时间复杂度的算法

    //117ms  击败了5.17%的用户
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int result=Integer.MIN_VALUE,value=0;
        for(int i=0;i<nums.length;i++){
            value=nums[i];
            if(value>result)result=value;
            for(int j=i+1;j<nums.length;j++){
                value*=nums[j];
                if(value>result)result=value;
            }
        }
        return result;
    }
}
