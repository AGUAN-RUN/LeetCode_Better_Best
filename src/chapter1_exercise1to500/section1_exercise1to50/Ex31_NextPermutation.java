package chapter1_exercise1to500.section1_exercise1to50;

import java.util.Arrays;
/*
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

 

示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：

输入：nums = [1]
输出：[1]
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100


* */
public class Ex31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)return;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                if(i==nums.length-2){
                    Arrays.sort(nums);
                    return;
                }
                continue;
            }else{
                break;
            }
        }
        int status=0;
        int min=Integer.MAX_VALUE;
        int minIndex=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    status=1;
                    if(nums[j]<min){
                        min=nums[j];
                        minIndex=j;
                    }

                }

            }
            if(status==1){
                nums[minIndex]=nums[i];
                nums[i]=min;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
        return;
    }
}
