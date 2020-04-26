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
public class Ex209_MinimumSizeSubarraySum {
    //滑动窗口问题
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int st=0;
        int end=0;
        int sum=0;
        //寻找包括 index=0的第一个子数组
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            end=i;
            if(sum>=s)break;
        }
        //缩尾
        while(sum-nums[st]>=s){
            sum-=nums[st];
            st++;
        }
        if(sum<s)return 0;
        for(int i=end+1;i<nums.length;i++){
            sum+=nums[i];
            end=i;
            while(sum-nums[st]>=s){
                sum-=nums[st];
                st++;
            }
        }
        return end-st+1;
    }
}
