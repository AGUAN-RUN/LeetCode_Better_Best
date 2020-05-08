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
