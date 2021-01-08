package chapter1_exercise1to500.section4_exercise151to200;
/*
* Given a positive integer, return its corresponding column title as appear in an Excel sheet.
* */
/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:

输入: 1
输出: "A"
示例 2:

输入: 28
输出: "AB"
示例 3:

输入: 701
输出: "ZY"


* */
public class Ex168_ExcelSheetColumnTitle {
    //妥妥的26进制
    //第一次ac 用时9ms 击败11.87%的用户
    public String convertToTitle(int n) {
        char[]strs=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String result="";
        n=n-1;
        while(n>=26){
            int value=n%26;
            result=strs[value]+result;
            n=n/26-1;
        }
        result=strs[n]+result;
        return result;
    }
}
