package chapter1_exercise1to500.section2_exercise51to100;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:

输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
示例 2:

输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
进阶:

这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？


* */
public class Ex81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        //尝试O(lgn)复杂度的算法，二分找旋转点，然后在二分找到目标元素
        //一没有旋转，二旋转了，可能有大量重复元素，甚至全部重复
        //若是除了一个元素全部重复，无法用二分找到旋转点，意味着无法用二分
        if(nums==null||nums.length==0)return false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)return true;
        }
        return false;
    }
}
