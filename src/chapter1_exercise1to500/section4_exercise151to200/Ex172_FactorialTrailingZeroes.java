package chapter1_exercise1to500.section4_exercise151to200;
/*Given an integer n, return the number of trailing zeroes in n!.
* Note: Your solution should be in logarithmic time complexity.
* */
/*
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。


* */
public class Ex172_FactorialTrailingZeroes {
    // n!分解公因式  统计因子5的总数即可  5一个5  25两个5 125三个5 625四个5 .....   （2*5就是一个10  因式中2的个数比五的个数多）

    //用时1ms  击败99.6%
    public int trailingZeroes(int n) {
        //由于可耻的力扣官方有测试用例有一个输入不是int，导致出现莫名其妙的bug
        //自己的解答
        //int result=0;
        //int base=5;
        //while(n>=base){
        //    result+=(n/base);
        //    base*=5;
        //}
        //return result;

        //官方正确的解答
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
