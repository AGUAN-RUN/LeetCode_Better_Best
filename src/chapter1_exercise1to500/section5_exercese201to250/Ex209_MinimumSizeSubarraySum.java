package chapter1_exercise1to500.section5_exercese201to250;
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
* */
/*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

 

示例：

输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 

进阶：

如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。


* */
public class Ex209_MinimumSizeSubarraySum {
    //滑动窗口问题

    //用时3ms  击败37.09%
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int st=0;
        int end=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            end=i;
            if(sum>=s) {
                while (sum - nums[st] >= s) {
                    sum -= nums[st];
                    st++;
                }
                int value=end-st+1;
                if(result>value)result=value;
            }
        }
        if(sum<s)return 0;
        return result;
    }
}
