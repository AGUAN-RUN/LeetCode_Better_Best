package chapter1_exercise1to500.section5_exercese201to250;

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
public class Ex205_IsomorphicStrings_3 {
    //ascII字符的 int 表示 从0到127  （java中 ascII字符在比较运算赋值会先转化为字符对应的int表示

    //优化第二次的代码
    //用时1ms  击败99.88%
    public boolean isIsomorphic(String s, String t) {
        if(s==null||"".equals(s)||t==null||"".equals(t)){
            if((s==null&&t==null)||("".equals(s)&&"".equals(t)))return true;
            return false;
        }
        return ifMap(s,t)&&ifMap(t,s);
    }
    public boolean ifMap(String s,String t) {
        int[]chars=new int [128];
        char[]c1=s.toCharArray();
        char[]c2=s.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(chars[c1[i]]==0){
                chars[c1[i]]=c2[i];
            }else if(chars[c1[i]]!=c2[i]){
                return false;
            }
        }
       return true;
    }
}
