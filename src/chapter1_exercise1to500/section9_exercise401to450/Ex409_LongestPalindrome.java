package chapter1_exercise1to500.section9_exercise401to450;
/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.


* */

/*
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


* */
public class Ex409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s==null||"".equals(s))return 0;
       //用一个数组来保存遍历过程中没有用来  组成回文串的每个字符的个数，若目前遍历的字符在该数组的计数大于0，就消耗掉这两个字符串用来组成回文串，
        // 并把数组中这个字符的计数清零
        //ASCII字符编码对应的int数 是 0-127 共128个
        int result=0;
        int length=s.length();
        int[]charNums=new int[128];
        for(int i=0;i<length;i++){
            int num=charNums[s.charAt(i)];
            if(num==1){
                result+=2;
                charNums[s.charAt(i)]=0;
            }else{
                charNums[s.charAt(i)]=1;
            }
        }
        if(result==length)return result;
        return  result+1;
    }
}
