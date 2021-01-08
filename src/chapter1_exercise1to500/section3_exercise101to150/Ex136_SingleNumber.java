package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4


* */
public class Ex136_SingleNumber {
    //时间复杂度为N但是使用额外空间
    //用时14ms，击败14.98%   。。。。。。
    public int singleNumber(int[] nums){
        Map<Integer,Integer> mps=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           mps.put(nums[i],mps.get(nums[i])==null?1:mps.get(nums[i])+1);
        }
        for(Integer a:mps.keySet()){
            if(mps.get(a)==1)return a;
        }
        return -1;
    }
}
