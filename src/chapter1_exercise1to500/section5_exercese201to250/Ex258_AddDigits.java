package chapter1_exercise1to500.section5_exercese201to250;
/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
* */
public class Ex258_AddDigits {
    //num加一 最终结果会加一   所以 返回值随着num递增1而递增1
    public int addDigits(int num) {
        if(num==0)return 0;
        if(num%9==0)return 9;
        return num%9;
    }
}
