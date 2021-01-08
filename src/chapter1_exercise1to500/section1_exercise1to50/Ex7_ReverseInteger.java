package chapter1_exercise1to500.section1_exercise1to50;
/*
* Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
* For the purpose of this problem,
* assume that your function returns 0 when the reversed integer overflows.

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1
* */
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。


* */
public class Ex7_ReverseInteger {
    //直接一步收集，用long的变量收集结果
    public int reverse(int x){
        long res=0;
        while(x!=0){
            res=res*10+x%10;
            x/=10;
        }
        if(res>(long)(Math.pow(2,31)-1)||res<(long)(-Math.pow(2,31))) return 0;
        return (int)res;

    }
}
