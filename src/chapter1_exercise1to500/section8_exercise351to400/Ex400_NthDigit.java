package chapter1_exercise1to500.section8_exercise351to400;
/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
* */

/*
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。

 

注意：n 是正数且在 32 位整数范围内（n < 231）。

 

示例 1：

输入：3
输出：3
示例 2：

输入：11
输出：0
解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。


* */
public class Ex400_NthDigit {
    //用时0ms java击败100%
    public int findNthDigit(int n) {
        long n1=(long)n;
        long i=1;
        long j=9;
        while(n1 >i*j){
            n1-=i*j;
            i++;
            j*=10;
        }
        long num=(n1-1)/i+j/9;
        long index=n1%i;
        if(index == 0)return (int)(num%10);
        for(long k=i;k>index;k--){
            num/=10;
        }
        return  (int)(num%10);
    }
}
