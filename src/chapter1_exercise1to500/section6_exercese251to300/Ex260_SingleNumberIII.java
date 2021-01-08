package chapter1_exercise1to500.section6_exercese251to300;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
* */

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :

输入: [1,2,1,3,2,5]
输出: [3,5]
注意：

结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？


* */
public class Ex260_SingleNumberIII {
    //8ms  击败21.16%
    public int[] singleNumber(int[] nums) {
        int [] result=new int[2];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer num=map.get(nums[i]);
            num=num==null?1:num+1;
            map.put(nums[i],num);
        }
        int i=0;
        for(int a:map.keySet()){
            if(map.get(a)==1)result[i++]=a;
        }
        return result;
    }
}
