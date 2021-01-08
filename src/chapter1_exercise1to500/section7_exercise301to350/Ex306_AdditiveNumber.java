package chapter1_exercise1to500.section7_exercise301to350;
/*
Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers.
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
 

Constraints:

num consists only of digits '0'-'9'.
1 <= num.length <= 35
Follow up:
How would you handle overflow for very large input integers?
* */

/*
累加数是一个字符串，组成它的数字可以形成累加序列。

一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:

输入: "112358"
输出: true
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
示例 2:

输入: "199100199"
输出: true
解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
进阶:
你如何处理一个溢出的过大的整数输入?


* */
public class Ex306_AdditiveNumber {
    //回溯法

    //关键的点在于 确定第一个数和第二个数，  然后迭代  注意迭代过程中，每个数可以是 0 但是不可以以零开头
    //暴力切分时间复杂度O(n^2)
    public boolean isAdditiveNumber(String num) {
        if(num==null||num.length()<3)return false;
        char[]nums=num.toCharArray();
        //用long  尽量避免运算产生溢出
        long a=nums[0]-'0';
        long b=0;
        for(int i=1;i<nums.length-1;i++){
            if(i>=nums.length-i)break;
            for(int j=i;j<nums.length;j++){
                b=b*10+(int)(nums[j]-'0');
                long c=a;
                long d=b;
                if(nums.length-j < j-i || nums.length-j<i)break;
                //满足条件之后  尝试迭代，不满足就回溯
                long value=0;
                int start=j+1;
                for(int k=j+1;k<nums.length;k++){
                    value=value*10+(int)(nums[k]-'0');
                    if(value == c+d){
                        c=d;
                        d=value;
                        value=0;
                        start=k+1;
                        if(k == nums.length-1)return true;
                    }else if(value > c+d){
                        break;
                    }
                    //是零 则不拼
                    if(nums[start] == '0' && value != c+d)break;
                }
                //是零 则不拼
                if(nums[i] == '0')break;
            }
            /*第一个是零，不能用0开头，不再迭代直接返回false*/
            if(a == 0)return false;
            a=a*10+(int)(nums[i]-'0');
            b=0;
        }
        return false;
    }
}
