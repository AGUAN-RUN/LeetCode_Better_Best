package chapter1_exercise1to500.section4_exercise151to200;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses
have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

*/
public class Ex198_HouseRobber {
    //贪心算法  遍历数组  保存每次迭代后的最大值和迭代前的最大值相比较   -->修正算法性质  贪心算法修正为动态规划
    //第i次迭代的最大值为num[i]+(第i-2次迭代与第i-3次迭代中的最大值）

    //时间复杂度为O(n)  空间复杂度为O(1)
    //以下算法错误，没有考虑到第i-3次迭代 到i 可能比第 i-2次迭代到 i 的和更大
    /*public int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
         for(int i=2;i<nums.length;i++){
             nums[i]=nums[i]+nums[i-2];
         }
         return nums[nums.length-1]>nums[nums.length-2]?nums[nums.length-1]:nums[nums.length-2];
    }*/
    //修正算法
    //用时0ms  击败100%java提交
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums.length==2)return nums[0]>nums[1]?nums[0]:nums[1];
        nums[2]=nums[2]+nums[0];
        for(int i=3;i<nums.length;i++){
            int value=nums[i-2]>nums[i-3]?nums[i-2]:nums[i-3];
            nums[i]=nums[i]+value;
        }
        return nums[nums.length-1]>nums[nums.length-2]?nums[nums.length-1]:nums[nums.length-2];
    }
    //修正说法
    /*1.贪心：每一步的最优解一定包含上一步的最优解，上一步之前的最优解则不作保留；

    动态规划：全局最优解中一定包含某个局部最优解，但不一定包含前一个局部最优解，因此需要记录之前的所有的局部最优解*/
    //由于每一步的最优解都保存在数组中，所以这是  动态规划算法  而不是贪心算法
}
