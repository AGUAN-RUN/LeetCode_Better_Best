package chapter1_exercise1to500.section6_exercese251to300;

import java.util.HashSet;
import java.util.Set;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
* */

/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    


* */
public class Ex290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null||pattern.length()==0||str==null||str.length()==0)return false;
        //使用一个26长度的String数组  来存储pattern的一个字符与str的一个子串之间的映射关系
        String[]map=new String[26];
        Set<String> set=new HashSet<>();
        //如果不用API的话很简单
        char[]cp=pattern.toCharArray();
        String[]strings=str.split(" ");
        if(cp.length!=strings.length)return false;
        for(int i=0;i<cp.length;i++){
            if(map[cp[i]-'a']==null){
                //如果这个字符串没有和其他字符匹配，添加映射 否则返回false
                if(set.contains(strings[i]))return false;
                set.add(strings[i]);
                map[cp[i]-'a']=strings[i];
            }else {
                if(!map[cp[i]-'a'].equals(strings[i]))return false;
            }
        }
        return true;
    }
}
