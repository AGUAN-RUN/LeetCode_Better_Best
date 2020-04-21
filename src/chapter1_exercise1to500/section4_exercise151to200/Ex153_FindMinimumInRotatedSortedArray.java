package chapter1_exercise1to500.section4_exercise151to200;
/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Ex153_FindMinimumInRotatedSortedArray {
    //O(n)复杂度算法

    //用时0ms 击败100%用户
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(min>nums[i])min=nums[i];
        }
        return min;
    }
}
