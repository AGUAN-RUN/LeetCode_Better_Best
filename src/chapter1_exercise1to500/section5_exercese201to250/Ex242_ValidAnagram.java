package chapter1_exercise1to500.section5_exercese201to250;
/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
* */
/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？


* */
public class Ex242_ValidAnagram {
    //2ms  击败99.89%
    public boolean isAnagram(String s, String t) {
        if(s==null&&t==null)return true;
        if(s==null||t==null)return false;
        //如果不包含 unicode 字符   包含unicode字符的话不要用数组，使用HashMap来储存每个字符以及每个字符出现的次数
        int[]n1=new int[128];
        int[]n2=new int[128];
        char[]c1=s.toCharArray();
        char[]c2=t.toCharArray();
        if(c1.length!=c2.length)return false;
        for(int i=0;i<c1.length;i++){
            n1[c1[i]]++;
            n2[c2[i]]++;
        }
        for(int i=0;i<n1.length;i++){
            if(n1[i]!=n2[i])return false;
        }
        return true;
    }
}
