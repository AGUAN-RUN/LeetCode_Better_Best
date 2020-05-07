package chapter1_exercise1to500.section5_exercese201to250;

import java.util.HashSet;
import java.util.Set;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
* */
public class Ex279_PerfectSquares_4 {
    //数学公式法  每个自然数数都可以用四个以内的自然数平方之和
    //n 的形式是 n = 4^{k}(8m+7)，那么 n 不能分解为 3 个自然数的平方的和  只能分解为自然数的平方的和

    //用时 1ms  java击败100%
    public int numSquares(int n) {
        int m=n;
        if(m%4==0){

        }

    }
}
