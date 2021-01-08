package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string ""

Constraints:
0 <= a, b, c <= 100
a + b + c > 0
*/

/*
如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

 

示例 1：

输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。
示例 2：

输入：a = 2, b = 2, c = 1
输出："aabbc"
示例 3：

输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。
 

提示：

0 <= a, b, c <= 100
a + b + c > 0
通过次数4,232提交次数8,655


* */
public class Ex1405_LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        int fa=0;
        int fb=0;
        int fc=0;
        int time=a+b+c;
        StringBuilder builder=new StringBuilder("");
        for(int i=0;i<time;i++){
            if(a==0&&b==0&&fc==2)return builder.toString();
            if(b==0&&c==0&&fa==2)return builder.toString();
            if(a==0&&c==0&&fb==2)return builder.toString();
            if(a>=b&&a>=c&&fa<2){
                builder.append("a");
                a--;
                fa++;
                fb=0;
                fc=0;
            }else if(a>=b&&a>=c&&fa==2){
                if(b>=c){
                    builder.append("b");
                    b--;
                    fb++;
                    fa=0;
                    fc=0;
                }else {
                    builder.append("c");
                    c--;
                    fc++;
                    fa=0;
                    fb=0;
                }
            }else if(b>=a&&b>=c&&fb<2){
                builder.append("b");
                b--;
                fb++;
                fa=0;
                fc=0;
            }else if(b>=a&&b>=c&&fb==2){
                if(a>=c){
                    builder.append("a");
                    a--;
                    fa++;
                    fb=0;
                    fc=0;
                }else {
                    builder.append("c");
                    c--;
                    fc++;
                    fa=0;
                    fb=0;
                }
            }else if(c>=a&&c>=b&&fc<2){
                builder.append("c");
                c--;
                fc++;
                fa=0;
                fb=0;
            }else {
                if(a>b){
                    builder.append("a");
                    a--;
                    fa++;
                    fb=0;
                    fc=0;
                }else {
                    builder.append("b");
                    b--;
                    fb++;
                    fa=0;
                    fc=0;
                }
            }
        }
        return builder.toString();
    }
}
