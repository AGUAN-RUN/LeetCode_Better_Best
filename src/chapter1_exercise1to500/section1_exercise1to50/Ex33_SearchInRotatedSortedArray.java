package chapter1_exercise1to500.section1_exercise1to50;
/*
给你一个整数数组 nums ，和一个整数 target 。

该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。

请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 
示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1
 

提示：

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
nums 肯定会在某个点上旋转
-10^4 <= target <= 10^4


* */
class Ex33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //直接进行二分查找，开始索引与结束索引分类判断
        if(nums==null||nums.length==0)return -1;
        int st=0;
        int end=nums.length-1;
        if(nums[st]==target)return st;
        if(nums[end]==target)return end;
        while(st+1<end){
            int mid=(st+end)/2;
            if(nums[mid]==target)return mid;
            //由于可能发生了旋转，mid的位置有两种，对于不同的mid，target的位置两种
            if(nums[mid]>nums[st]){
                if(target<nums[mid]&&target>nums[st]){
                    end=mid;
                }else{
                    st=mid;
                }
            }else if(nums[mid]<nums[st]){
                if(target>nums[mid]&&target<nums[end]){
                    st=mid;
                }else{
                    end=mid;
                }
            }

        }
        return -1;
    }
}
