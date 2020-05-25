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
