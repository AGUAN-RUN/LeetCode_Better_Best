package chapter1_exercise1to500.section4_exercise151to200;

import java.util.Arrays;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array
*/
public class Ex169_MajorityElement_3 {
    //摩尔投票法  对拼消耗法： 不用就消耗，相同则递增   最坏情况下也会返回那个票数超过一半的兄弟

    //还是2ms
    public int majorityElement(int[] nums) {
        int number=1;
        int value=nums[0];
        for(int i=1;i<nums.length;i++){
            if(number==0){
                number=1;
                value=nums[i];
            }else {
                if (nums[i] == value) {
                    number--;
                }else {
                    number++;
                }
            }
        }
        return value;
    }
}
