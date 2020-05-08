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
