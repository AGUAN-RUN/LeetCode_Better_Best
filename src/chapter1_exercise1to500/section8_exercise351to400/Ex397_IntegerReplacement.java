package chapter1_exercise1to500.section8_exercise351to400;
/*
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
* */

/*
给定一个正整数 n ，你可以做如下操作：

如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？

 

示例 1：

输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1
示例 2：

输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1
示例 3：

输入：n = 4
输出：2
 

提示：

1 <= n <= 231 - 1


* */
public class Ex397_IntegerReplacement {
    //用时 0ms  java击败 100%
    public int integerReplacement(int n) {
        int res=0;
        if(n == 2147483647)return 32;
        while (n > 1){
            res++;
            if(n%2 == 0){
                n/=2;
            }else if(n == 3){
                return res+1;
            }else if ((n+1)%2 == 0 && (n+1)/2%2 == 0){
                n=n+1;
            }else if((n-1)%2 == 0 && (n-1)/2%2 == 0){
                n=n-1;
            }
        }
        return res;
    }
}
