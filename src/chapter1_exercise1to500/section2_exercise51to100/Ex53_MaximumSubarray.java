package chapter1_exercise1to500.section2_exercise51to100;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。


* */
public class Ex53_MaximumSubarray {
    //暴力求解
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length<1)return -1;
        int result=Integer.MIN_VALUE;
        int temp;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            if(nums[i]>result)result=nums[i];
            for(int j=i+1;j<nums.length;j++){
                temp+=nums[j];
                if(temp>result)result=temp;
            }
        }
        return result;
    }
}
