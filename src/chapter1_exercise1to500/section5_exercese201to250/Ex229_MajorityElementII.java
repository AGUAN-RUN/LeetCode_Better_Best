package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
* */
/*
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

 

示例 1：

输入：[3,2,3]
输出：[3]
示例 2：

输入：nums = [1]
输出：[1]
示例 3：

输入：[1,1,1,3,3,2,2,2]
输出：[1,2]
 

提示：

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


* */
public class Ex229_MajorityElementII {
    //摩尔投票法  对冲消耗法 三人版

    // 一个元素的个数超过 n/3  则元素个数 至少为  n/3+1  可知数组中元素个数超过n/3的至多不超过两个 由（n/3+1）*3>n
    //当遍历到三个不同的元素，则把这三个不同的元素个数各减去一个，剩下的一个（或两个）元素 元素的个数 '可能' 超过n/3 可以遍历数组统计确认

    //用时2ms  击败99.61%的用户
    public List<Integer> majorityElement(int[] nums) {
        if(nums==null||nums.length==0)return new ArrayList<>();
        int[]a=new int[2];
        int[]b=new int[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==a[0]){
                a[1]++;
            }else if(nums[i]==b[0]){
                b[1]++;
            }else {
                if (a[1] == 0 || b[1] == 0) {
                    if (a[1] == 0 ) {
                        a[0] = nums[i];
                        a[1]=1;
                    } else if (b[1]==0){
                        b[0]=nums[i];
                        b[1]=1;
                    }
                }else{
                    a[1]--;
                    b[1]--;
                }
            }
        }
        List<Integer>list=new ArrayList<>();
        int num=0;
        if(a[1]>0){
            for(int i=0;i<nums.length;i++){
                if(a[0]==nums[i])num++;
            }
            if(num>(nums.length/3))list.add(a[0]);
        }
        num=0;
        if(b[1]>0){
            for(int i=0;i<nums.length;i++){
                if(b[0]==nums[i])num++;
            }
            if(num>(nums.length/3))list.add(b[0]);
        }
        return list;
    }
}
