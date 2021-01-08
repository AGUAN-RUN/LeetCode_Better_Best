package chapter1_exercise1to500.section5_exercese201to250;

import java.util.Arrays;

/*
* Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

Note:
You may assume both s and t have the same length.
*/
/*
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

 

示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true
 

提示：

可以假设 s 和 t 长度相同。


* */
public class Ex205_IsomorphicStrings {
    //ascII字符的 int 表示 从0到127  （java中 ascII字符在比较运算赋值会先转化为字符对应的int表示

    //用时5ms  击败95%
    public boolean isIsomorphic(String s, String t) {
        if(s==null||"".equals(s)||t==null||"".equals(t)){
            if((s==null&&t==null)||("".equals(s)&&"".equals(t)))return true;
            return false;
        }
        int[]chars=new int [128];
        //优化 由于0 对应的是 ascII的  null  数组中不会出现null 所以不用去用-1填充默认的0
        Arrays.fill(chars,-1);
        //优化 下面可以提取出一个方法，提高复用性
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(chars[c1]==-1){
                chars[c1]=c2;
            }else if(chars[c1]!=c2){
                return false;
            }
        }
        //优化  可以初始化两个数组，以空间换时间
        Arrays.fill(chars,-1);
        for(int i=0;i<s.length();i++){
            char c2=s.charAt(i);
            char c1=t.charAt(i);
            if(chars[c1]==-1){
                chars[c1]=c2;
            }else if(chars[c1]!=c2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ex205_IsomorphicStrings test=new Ex205_IsomorphicStrings();
        test.isIsomorphic("fooo","baor");
    }
}
