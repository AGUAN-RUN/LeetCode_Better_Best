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
/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:

输入: 1
输出: true
解释: 20 = 1
示例 2:

输入: 16
输出: true
解释: 24 = 16
示例 3:

输入: 218
输出: false


* */
public class Ex231_PowerOfTwo {
    //位运算  可以加上二分来确定位置  时间复杂度 O(lg30)

    //用时1ms 击败100%
    public boolean isPowerOfTwo(int n) {
        int st=0;
        int end=30;
        if(n<=0||n>(1<<30))return false;
        if(n==1||n==(1<<30))return true;
        while(st+1<end){
            int mid = (st+end)/2;
            int base=1<<mid;
            if(n==base){
                return true;
            }else if(n>base){
                st=mid;
            }else{
                end=mid;
            }
        }
        return false;
    }
}
