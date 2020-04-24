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
public class Ex205_IsomorphicStrings_2 {
    //ascII字符的 int 表示 从0到127  （java中 ascII字符在比较运算赋值会先转化为字符对应的int表示

    //优化第一次的代码
    //还是5ms
    public boolean isIsomorphic(String s, String t) {
        if(s==null||"".equals(s)||t==null||"".equals(t)){
            if((s==null&&t==null)||("".equals(s)&&"".equals(t)))return true;
            return false;
        }
        return ifReplaceCharOneToOne(s,t)&&ifReplaceCharOneToOne(t,s);
    }

    //方法名简单直接一点  比如改为 ifMap，也可以提高效率  尽量避免方法名过长
    public boolean ifReplaceCharOneToOne(String s,String t) {
        int[]chars=new int [128];
        //直接定义length = s.length()  迭代的布尔表达式换成i<s.length()  可以避免在迭代过程中一次次访问 字符对象的属性，可以提高效率
        for(int i=0;i<s.length();i++){
            //优化  由于这里要一次又一次的定义变量与初始化赋值 不如直接把字符串转化为字符数组，只定义一次
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(chars[c1]==0){
                chars[c1]=c2;
            }else if(chars[c1]!=c2){
                return false;
            }
        }
       return true;
    }
}
