package chapter1_exercise1to500.section1_exercise1to50;
/*
*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
* */
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"


* */
public class Ex5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null||s.equals("")||s.length()==1)return s;
        char[]crs=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int left=0;
        int right=0;
        for(int i=0;i<crs.length;i++){
            int j=i-1;
            int k=i+1;
            while(j>=0&&k<crs.length&&crs[j]==crs[k]){
                j-=1;
                k+=1;
            }
            if((k-j-2)>=(right-left)){
                right=k-1;
                left=j+1;
            }
        }
        for(int i=0;i<crs.length;i++){
            int j=i;
            int k=i+1;
            while(j>=0&&k<crs.length&&crs[j]==crs[k]){
                j-=1;
                k+=1;
            }
            if((k-j-2)>=(right-left)){
                right=k-1;
                left=j+1;
            }
        }
        for(int i=left;i<=right;i++){
            sb.append(crs[i]);
        }

        return sb.toString();
    }
}
