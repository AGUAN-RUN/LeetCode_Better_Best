package chapter1_exercise1to500.section1_exercise1to50;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109


* */
public class Ex34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //null 没有值，一个值，另个值，三个以上的值
        if(nums==null||nums.length==0)return new int[]{-1,-1};
        int lt=0;
        int rt=nums.length-1;
        int temp;
        int start=-1;
        if(nums[0]==target){
            start=0;
        }else if(nums[rt]==target&&nums[rt-1]<target){
            start=rt;
            return new int[]{rt,rt};
        }else{
            while(rt>lt+1){
                temp=(lt+rt)/2;
                if(nums[temp]==target&&nums[temp-1]<target){
                    start=temp;
                    break;
                }else if(nums[temp]>=target){
                    rt=temp;
                }else if(nums[temp]<target){
                    lt=temp;
                }

            }
        }
        if(start==-1){
            return new int[]{-1,-1};
        }else if(start!=-1&&nums[nums.length-1]==target){
            return new int[]{start,nums.length-1};
        }else if(start!=-1&&nums[start+1]>target){
            return new int[]{start,start};
        }else{
            lt=start;
            rt=nums.length-1;
            while(rt>lt+1){
                temp=(lt+rt)/2;
                if(nums[temp]==target&&nums[temp+1]>target){
                    return new int[]{start,temp};
                }else if(nums[temp]>target){
                    rt=temp;
                }else if(nums[temp]<=target){
                    lt=temp;
                }
            }
        }
        return new int[]{-1,-1};

    }
}
