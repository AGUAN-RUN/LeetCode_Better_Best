package chapter1_exercise1to500.section4_exercise151to200;
/*A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.

Note:
Your solution should be in logarithmic complexity.
*/
public class Ex_162_FindPeakElement {
    //左边递增，右边递减  必有峰值
    //用时0ms  击败100%的用户
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        if(nums.length==1)return 0;
        int st=0,end=nums.length-1;
        if(nums[0]>nums[1])return 0;
        if(nums[end]>nums[end-1])return end;
        while(st+1<end){
            int mid=(st+end)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                st=mid;
            }else{
                end=mid;
            }
        }
        return -1;
    }
}
