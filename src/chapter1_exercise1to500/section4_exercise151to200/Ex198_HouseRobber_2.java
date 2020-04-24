package chapter1_exercise1to500.section4_exercise151to200;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses
have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

*/
public class Ex198_HouseRobber_2 {
    //简洁好理解的算法   更优美的代码
    public int rob(int[] nums) {
        int preMax=0,currMax=0;
        for(int i=0;i<nums.length;i++){
            int max=Math.max(currMax,preMax+nums[i]);
            preMax=currMax;
            currMax=max;
        }
        return currMax;
    }
}
