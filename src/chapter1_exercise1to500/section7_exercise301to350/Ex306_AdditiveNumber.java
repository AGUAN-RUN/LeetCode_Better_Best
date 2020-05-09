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
public class Ex306_AdditiveNumber {
    //回溯法

    //关键的点在于 确定第一个数和第二个数，  然后迭代
    //暴力切分时间复杂度O(n^2)
    public boolean isAdditiveNumber(String num) {
        if(num==null||num.length()<3)return false;
        char[]nums=num.toCharArray();
        int a=nums[0]-'0';
        int b=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i] == 0){
                a*=10;
                i++;
            }
            if(i>=nums.length-i)break;
            for(int j=i;j<nums.length;j++){
                b=b*10+nums[j]-'0';
                if(j+1<nums.length&&nums[j+1]==0){
                    b*=10;
                    j++;
                }
                int c=a;
                int d=b;
                if(nums.length-j < j-i || nums.length-j<i)break;
                //满足条件之后  尝试迭代，不满足就回溯
                int value=0;
                for(int k=j+1;k<nums.length;k++){
                    value=value*10+nums[k]-'0';
                    if(value == c+d){
                        c=d;
                        d=value;
                        value=0;
                    }else if(value > c+d){
                        break;
                    }
                    if(k == nums.length-1)return true;
                }
            }
            a=a*10+nums[i]-'0';
            b=0;
        }
        return false;
    }
}
