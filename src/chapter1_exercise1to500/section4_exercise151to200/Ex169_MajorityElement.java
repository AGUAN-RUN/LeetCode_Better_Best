package chapter1_exercise1to500.section4_exercise151to200;

import java.util.Arrays;

/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array
*/
public class Ex169_MajorityElement {
    //用api排序
    //用时2ms  击败88%的用户
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
