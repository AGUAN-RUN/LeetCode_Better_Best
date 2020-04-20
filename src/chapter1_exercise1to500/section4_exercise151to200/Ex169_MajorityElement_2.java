package chapter1_exercise1to500.section4_exercise151to200;

import java.util.HashMap;
import java.util.Map;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array
*/
public class Ex169_MajorityElement_2 {
    //用时20ms  击败22.26%
    public int majorityElement(int[] nums) {
        //这里使用hashmap储存元素的效率很低，可能是由于太多重复的元素，储存元素时大量进行红黑树的构建
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
        }
        for(Integer a:map.keySet()){
            if(map.get(a)>nums.length/2)return a;
        }
        return -1;
    }
}
