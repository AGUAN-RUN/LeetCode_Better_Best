package chapter1_exercise1to500.section5_exercese201to250;
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
public class Ex279_PerfectSquares {
    //贪心算法
    public int numSquares(int n) {
        int a=(int)Math.sqrt(n);
        if(a*a==n)return 1;
        return -1;
    }

    public static void main(String[] args) {
        int a=(int)Math.sqrt(13);
        System.out.println(a);
    }
}
