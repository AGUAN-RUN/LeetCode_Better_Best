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
    //n 的形式是 n = 4^{k}(8m+7)，那么 n 不能分解为 3 个自然数的平方的和  只能分解为四个自然数的平方的和

    //用时 1ms  java击败100% nice!
    public int numSquares(int n) {
        //判断m是不是本身就是 一个整数的平方
        if(n==Math.pow((int)Math.sqrt(n),2))return 1;

        //判断 m 是不是只能拆四个整数的平方
        int m=n;
        if(m%8==7)return 4;
        while (m%4 == 0 && m != 1){
            m/=4;
            if(m%8==7)return 4;
        }

        //判断 m 是不是能拆两个 整数的平方

        for(int i=(int)Math.sqrt(n);i>0;i--){
           int value=i*i;
           int subval=n-i*i;
           if(subval>value)break;
           if(subval==(Math.pow((int)Math.sqrt(subval),2)))return 2;
        }

        return 3;
    }
}
