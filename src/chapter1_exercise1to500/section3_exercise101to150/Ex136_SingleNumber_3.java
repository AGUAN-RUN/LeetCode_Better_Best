package chapter1_exercise1to500.section3_exercise101to150;

import java.util.Arrays;

/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Ex136_SingleNumber_3 {
    //时间复杂度为N 不使用额外空间
    //异或运算的交换律  a^b^a=a^a^b  a^a=0 0^b=b
    // 用时1ms ， 击败99.71%的用户
    public int singleNumber(int[] nums){
        int result=0;
        for(int i=0;i<nums.length;i++){
          result=result^nums[i];
        }
        return result;
    }
}
