package chapter1_exercise1to500.section5_exercese201to250;
/*
* Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/
public class Ex201_BitwiseANDOfNumbersRange {
    //用时6ms  击败99.66%提交
    public int rangeBitwiseAnd(int m, int n) {
        int i=1<<30;
        int result=0;
        while(i>0) {
            if ((m & i) == (n & i)){
                result=result|(n & i);
                i=i>>1;
            }else {
                break;
            }
        }
        return result;
    }
     //想了 原来是leetcode 执行代码的的预期结果是错误的
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(3451234));
        System.out.println(Integer.toBinaryString(2352351));
        System.out.println("------------------");
        System.out.println(Integer.toBinaryString(2097152));
        System.out.println(Integer.toBinaryString(2138178));
    }
}
