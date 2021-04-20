package chapter4_exercise1501to2000.section7_exercise1801to1850;
/*英文描述*/

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 
Constraints:
1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
* */

/*中文描述*/
/*
全字母句 指包含英语字母表中每个字母至少一次的句子。
给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
如果是，返回 true ；否则，返回 false 。

 

示例 1：
输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
输出：true
解释：sentence 包含英语字母表中每个字母至少一次。
示例 2：
输入：sentence = "leetcode"
输出：false
 
提示：
1 <= sentence.length <= 1000
sentence 由小写英语字母组成
* */


import java.util.HashSet;
import java.util.Set;

public class Ex1832_CheckIfTheSentenceIsPangram {
    //直接判断sentence中有没有a-z即可。一下代码太重，实现过程画蛇添足，针对性不够，效率过低
    public boolean checkIfPangram(String sentence) {
        if(sentence==null || sentence.length()<26)return false;
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<sentence.length();i++){
            set.add(sentence.charAt(i));
        }
        if(set.size() == 26)return true;
        return false;

    }
}
