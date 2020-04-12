package chapter1_exercise1to500.section3_exercise101to150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Ex136_SingleNumber_2 {
    //时间复杂度为NlogN 但是不使用额外空间
    //用时3ms ， 击败38.8%的用户
    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
           if(i+1>=nums.length||nums[i]!=nums[i+1])return nums[i];
           i++;
        }
        return -1;
    }
}
