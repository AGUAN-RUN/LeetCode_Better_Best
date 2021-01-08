package chapter1_exercise1to500.section4_exercise151to200;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses
have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

*/
/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 

提示：

0 <= nums.length <= 100
0 <= nums[i] <= 400


* */
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
