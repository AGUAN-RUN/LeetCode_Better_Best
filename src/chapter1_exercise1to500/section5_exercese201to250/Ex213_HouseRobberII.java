package chapter1_exercise1to500.section5_exercese201to250;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
* */
public class Ex213_HouseRobberII {
    //动态规划问题

    //用时0ms  击败100%的提交
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        //由于存在闭环，分类讨论，一种摒弃最后一个房子，一种摈弃第一个房子
        int preMax1=0;
        int currMax1=0;
        int preMax2=0;
        int currMax2=0;
        for(int i=1;i<nums.length;i++){
            int value=preMax1+nums[i];
            preMax1=currMax1;
            currMax1=value>currMax1?value:currMax1;
        }
        for(int i=0;i<nums.length-1;i++){
            int value=preMax2+nums[i];
            preMax2=currMax2;
            currMax2=value>currMax2?value:currMax2;
        }
        return currMax1>currMax2?currMax1:currMax2;
    }
}
