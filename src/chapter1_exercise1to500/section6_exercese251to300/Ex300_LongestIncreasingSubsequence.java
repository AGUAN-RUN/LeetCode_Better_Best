package chapter1_exercise1to500.section6_exercese251to300;

import java.util.ArrayList;
import java.util.List;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
* */

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

 
示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1
 

提示：

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

进阶：

你可以设计时间复杂度为 O(n2) 的解决方案吗？
你能将算法的时间复杂度降低到 O(n log(n)) 吗?


* */
public class Ex300_LongestIncreasingSubsequence {
    //动态的分析问题

    //用一个 使用一个容器 来保存 nums 中以nums[i]结尾的最长序列长度（i=0...nums.length）

    //12ms   java击败72.01%
    public int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int[]lengths=new int [nums.length];
        lengths[0]=1;
        int res=lengths[0];
        for(int i=1;i<nums.length;i++){
            int value=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(lengths[j]>value)value=lengths[j];
                }
            }
            lengths[i]=value+1;
            if(lengths[i]>res)res=lengths[i];
        }
        return res;
    }

}
