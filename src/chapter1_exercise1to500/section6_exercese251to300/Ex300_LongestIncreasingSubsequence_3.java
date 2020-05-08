package chapter1_exercise1to500.section6_exercese251to300;

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
public class Ex300_LongestIncreasingSubsequence_3 {
    //动态规划 + 二分法
    //用一个 使用一个辅助数组temp 数组第i位 保存迭代过程长度为i+1的 的升序序列最小尾数

    //严格升序序列 一个序列的后一个值大于其前一个值  所以 长度为i的 的升序序列最小尾数要大于 长度小于i的的升序序列最小尾数
    //所以可知 temp数组是严格递增的  可以使用二分

    //在2 的基础上小小优化
    //用时0ms  java击败100%
    public int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int[]dp=new int [nums.length];
        dp[0]=nums[0];
        int res=0;
        for(int i=1;i<nums.length;i++){
            //先判断nums[i]是不是大于最长子序列的最小尾数  如是是 直接序列长度 +1  且该长度最小尾数为 num[i]  进行下一轮迭代
            if(nums[i] > dp[res]){
                dp[++res]=nums[i];
                continue;
            }
            int left=0;
            int right=res;
            while (left<right){
                int mid=left+(right-left)/2;
                if(nums[i] > dp[mid]){
                    left=mid+1;
                }else if(nums[i] < dp[mid]){
                    right=mid;
                }else{
                    left=mid;
                    break;
                }
            }
            if(dp[left]!=nums[i]){
                dp[left]=nums[i];
            }
        }
        return res+1;
    }
}
