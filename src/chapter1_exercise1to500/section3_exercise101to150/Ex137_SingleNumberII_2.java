package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashMap;
import java.util.Map;

/*Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Ex137_SingleNumberII_2 {
    //每个数都有36位，某位上1的个数不是3的倍数时，说明只出现一次的数该位为1
    //位运算 & | ~ ^
    //位移  >>(符号位也会右移) <<（JAVA 符号位不变，左移，低位补0） >>>
    //不使用额外空间，时间复杂度 O(36n)

    //5ms 击败31%的用户  有待优化--直接用 处理逻辑电路的思路
    public int singleNumber(int[] nums) {
       int result=0;
       //对于32的int，最高位为符号位  1<<32==1
       for(int i=0;i<32;i++){
           int base=1<<i;
           int num=0;
           for(int j=0;j<nums.length;j++){
               if((nums[j]&base)!=0)num++;
           }
           if(num%3==1)result+=base;
       }
       return result;
    }
}
