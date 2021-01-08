package chapter1_exercise1to500.section4_exercise151to200;
/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。

请找出其中最小的元素。

 

示例 1：

输入：nums = [3,4,5,1,2]
输出：1
示例 2：

输入：nums = [4,5,6,7,0,1,2]
输出：0
示例 3：

输入：nums = [1]
输出：1
 

提示：

1 <= nums.length <= 5000
-5000 <= nums[i] <= 5000
nums 中的所有整数都是 唯一 的
nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转


* */
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
