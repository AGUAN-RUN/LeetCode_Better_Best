package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*
* Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit.
That is, no two adjacent characters have the same type.
Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*
* */
public class Ex1417_ReformatTheString {
    //使用两个数组,一个存放数字，一个存放字母
    public String reformat(String s) {
        if(s==null||s.length()==0)return s;
        char[]strs=s.toCharArray();
        char[]s1=new char[strs.length];
        char[]s2=new char[strs.length];
        int n=0,m=0;
        for(int i=0;i<strs.length;i++){
            if(strs[i]>='0'&&strs[i]<='9'){
                s1[n++]=strs[i];
            }else {
                s2[m++]=strs[i];
            }
        }
        //字母个数和数字个数之间数目至多相差一个
        if(m>n+1||n>m+1) return "";
        //循环拼接
        StringBuilder sb=new StringBuilder();
        if(m>n){
            for(int i=0;i<n;i++){
                sb.append(s2[i]);
                sb.append(s1[i]);
            }
            sb.append(s2[m-1]);
        }else {
            for(int i=0;i<m;i++){
                sb.append(s1[i]);
                sb.append(s2[i]);
            }
            if(n>m)sb.append(s1[n-1]);
        }
        return sb.toString();

    }
}
