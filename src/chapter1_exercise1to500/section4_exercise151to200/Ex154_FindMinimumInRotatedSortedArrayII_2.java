package chapter1_exercise1to500.section4_exercise151to200;
/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
The array may contain duplicates.
*/
public class Ex154_FindMinimumInRotatedSortedArrayII_2 {
    //O(lgn)复杂度算法

    //用时0ms 击败100%用户
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        //判断是不是第一个或者最后一个
        int st=0;
        int end=nums.length-1;
        //去重
        while(st<end&&nums[st]==nums[st+1])st++;
        while(end>st&&nums[end]==nums[st])end--;
        while(end>st&&nums[end]==nums[end-1])end--;

        if(st==end)return nums[st];
        if(nums[st]<nums[st+1]&&nums[st]<nums[end])return nums[st];
        if(nums[end]<nums[end-1]&&nums[end]<nums[st])return nums[end];
        while(st+1<end){
            int mid=(st+end)/2;
            if(nums[mid]>nums[st]){
                st=mid;
                //去重
                while(st<end&&nums[st]==nums[st+1])st++;
            }else {
                //去重
                while(mid>st&&nums[mid]==nums[mid-1])mid--;
                if(nums[mid]<nums[mid-1]){
                    return nums[mid];
                }else {
                    end=mid;
                }
            }
        }
        return 0;
    }
}
