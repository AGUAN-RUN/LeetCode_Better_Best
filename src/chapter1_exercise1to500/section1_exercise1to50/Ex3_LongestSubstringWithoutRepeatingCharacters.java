package chapter1_exercise1to500.section1_exercise1to50;

import java.util.HashMap;
import java.util.Map;
/*
* Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces
/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0
 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成


 */
public class Ex3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)return -1;
        int res=0;
        int left=0;
        char[]chars=s.toCharArray();
        Map<Integer,Character> tempMap=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(tempMap.containsValue(chars[i])){
                while(tempMap.get(left)!=chars[i]){
                    tempMap.remove(left);
                    left+=1;
                }
                tempMap.remove(left++);
            }
            tempMap.put(i,chars[i]);
            res=tempMap.size()>res?tempMap.size():res;
        }
        return res;

    }
}
