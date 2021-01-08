package chapter1_exercise1to500.section4_exercise151to200;
/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
The array may contain duplicates.
*/
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

注意数组中可能存在重复的元素。

示例 1：

输入: [1,3,5]
输出: 1
示例 2：

输入: [2,2,2,0,1]
输出: 0
说明：

这道题是 寻找旋转排序数组中的最小值 的延伸题目。
允许重复会影响算法的时间复杂度吗？会如何影响，为什么？


* */
public class Ex154_FindMinimumInRotatedSortedArrayII {
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
