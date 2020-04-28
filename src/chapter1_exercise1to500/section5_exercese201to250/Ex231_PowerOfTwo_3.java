package chapter1_exercise1to500.section5_exercese201to250;
/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
* */
public class Ex231_PowerOfTwo_3 {
    //使用 n&(n-1)的性质会把n的二进制位最右边的一个1置为0的性质设计算法  算法时间空间复杂度都是  O(1)

    //用时1ms 击败100%
    public boolean isPowerOfTwo(int n) {
        if(n<1)return false;
       if((n&(n-1))==0)return true;
       return false;
    }
}
