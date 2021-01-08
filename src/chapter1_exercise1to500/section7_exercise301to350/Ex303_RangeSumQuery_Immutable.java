package chapter1_exercise1to500.section7_exercise301to350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
* */

/*
给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。

实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 

示例：

输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 

提示：

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
最多调用 104 次 sumRange 方法
通过次数63,526提交次数98,737


* */
public class Ex303_RangeSumQuery_Immutable {
    //用一个二维数组来记录已经计算了的值

    //一个测试用例数组超大  内存溢出了

    long[][]temp;
    int[]nums;
    public Ex303_RangeSumQuery_Immutable(int[] nums) {
        if(nums!=null) {
            this.nums = nums;
            temp = new long[nums.length][];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = new long[temp.length - i];
                Arrays.fill(temp[i], Long.MAX_VALUE);
            }
        }
    }

    public int sumRange(int i, int j) {
        if(j<i||i<0)return -1;
        if(nums==null||nums.length==0)return -1;
         if(temp[i][j-i]!=Long.MAX_VALUE){
             return (int)temp[i][j-i];
         }
         int res=0;
         for(int k =i;k<=j;k++){
             res+=nums[k];
         }
         temp[i][j-i]=res;
         return res;
    }

}
