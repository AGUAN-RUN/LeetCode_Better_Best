package chapter1_exercise1to500.section2_exercise51to100;
/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

题目数据保证答案肯定是一个 32 位的整数。

 

示例 1：

输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：

输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：

输入：s = "0"
输出：0
示例 4：

输入：s = "1"
输出：1
示例 5：

输入：s = "2"
输出：1
 

提示：

1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。


* */
public class Ex91_DecodeWays {
    //使用分治法和递归方法求解
    //注意字符串中的0;
    //只打败了 11 %的提交代码，可以说效率非常低，待改进
    public int numDecodings(String s) {
        if(s==null||"".equals(s))return 0;
        char[]chars=s.toCharArray();
        return  numDecodingsWorker(chars,0);
    }
    public int numDecodingsWorker(char[]chars,int index){
        if(index<chars.length&&chars[index]=='0')return 0;
        if(index>=chars.length-1)return 1;
        if(chars[index]=='1'||(chars[index]=='2'&&chars[index+1]<'7')){
            return numDecodingsWorker(chars,index+1)+numDecodingsWorker(chars,index+2);
        }else{
            return numDecodingsWorker(chars,index+1);
        }
    }
}
