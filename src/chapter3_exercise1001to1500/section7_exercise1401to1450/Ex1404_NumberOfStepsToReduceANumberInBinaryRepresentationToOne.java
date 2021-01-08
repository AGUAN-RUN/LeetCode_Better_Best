package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*Given a number s in their binary representation. Return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It's guaranteed that you can always reach to one for all testcases.

Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
*/

/*
给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：

如果当前数字为偶数，则将其除以 2 。

如果当前数字为奇数，则将其加上 1 。

题目保证你总是可以按上述规则将测试用例变为 1 。

 

示例 1：

输入：s = "1101"
输出：6
解释："1101" 表示十进制数 13 。
Step 1) 13 是奇数，加 1 得到 14 
Step 2) 14 是偶数，除 2 得到 7
Step 3) 7  是奇数，加 1 得到 8
Step 4) 8  是偶数，除 2 得到 4 
Step 5) 4  是偶数，除 2 得到 2 
Step 6) 2  是偶数，除 2 得到 1 
示例 2：

输入：s = "10"
输出：1
解释："10" 表示十进制数 2 。
Step 1) 2 是偶数，除 2 得到 1
示例 3：

输入：s = "1"
输出：0
 

提示：

1 <= s.length <= 500
s 由字符 '0' 或 '1' 组成。
s[0] == '1'


* */
public class Ex1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    //直接将字符串转化为整数，可能由于字符串太长而溢出
    public int numSteps(String s) {
        if(s==null||s.length()==0)return 0;
        s="0"+s;
        char[]strs=s.toCharArray();
        if(strs[strs.length-1]=='0'){
            return caculateNumSteps(strs,-1,0,strs.length-1);
        }else {
            return caculateNumSteps(strs,1,0,strs.length-1);
        }

    }
    public int caculateNumSteps(char[]strs,int flag,int total,int begin){
        if(strs[0]=='0'&&begin==1)return total;
        if(strs[0]=='1'&&begin==0)return total;
        if(flag==1){
            int status=1;
            for(int i=begin;i>=0;i--){
                if(status==0)break;
                if(strs[i]=='1'){
                    strs[i]='0';
                }else {
                    strs[i]='1';
                    status=0;
                }
            }
            return caculateNumSteps(strs,-1,total+1,begin);
        }else {
            begin=begin-1;
            if(strs[begin]=='0'){
                return caculateNumSteps(strs,-1,total+1,begin);
            }else {
                return caculateNumSteps(strs,1,total+1,begin);
            }
        }
    }
}
