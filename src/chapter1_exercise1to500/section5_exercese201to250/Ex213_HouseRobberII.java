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
/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

 

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [0]
输出：0
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 1000


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
