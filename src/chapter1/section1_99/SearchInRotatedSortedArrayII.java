package chapter1.section1_99;

public class SearchInRotatedSortedArrayII {
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
