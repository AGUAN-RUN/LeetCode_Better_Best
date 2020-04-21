package chapter1_exercise1to500.section4_exercise151to200;
/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Ex153_FindMinimumInRotatedSortedArray_2 {
    //利用旋转的特点设计  O(lgn)复杂度算法

    //用时0ms 击败100%
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        //判断是不是第一个或者最后一个
        int st=0;
        int end=nums.length-1;
        if(nums[0]<nums[1]&&nums[0]<nums[end])return nums[0];
        if(nums[end]<nums[nums.length-2]&&nums[end]<nums[0])return nums[end];
        while(st+1<end){
            int mid=(st+end)/2;
            if(nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]>nums[st]){
                st=mid;
            }else {
                end=mid;
            }
        }
        return 0;
    }
}
