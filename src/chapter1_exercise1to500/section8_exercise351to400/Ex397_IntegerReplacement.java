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
