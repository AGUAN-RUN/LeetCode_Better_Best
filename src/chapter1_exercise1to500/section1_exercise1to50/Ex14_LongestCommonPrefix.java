package chapter1_exercise1to500.section1_exercise1to50;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。


* */
public class Ex14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        StringBuffer sb=new StringBuffer("");
        char a;
        for(int k=0;k<strs[0].length();k++){
            a=strs[0].charAt(k);
            for(int i=1;i<strs.length;i++){
                if(strs[i].length()<k+1){
                    return sb.toString();
                }
                if(strs[i].charAt(k)==a){
                    continue;
                }else{
                    return sb.toString();
                }
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
