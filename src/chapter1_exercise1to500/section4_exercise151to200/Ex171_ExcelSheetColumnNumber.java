package chapter1_exercise1to500.section4_exercise151to200;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.
*/
/*
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
致谢：
特别感谢 @ts 添加此问题并创建所有测试用例。


* */
public class Ex171_ExcelSheetColumnNumber {
    //用时2ms 击败42.08%的用户
    public int titleToNumber(String s) {
        if(s==null||s.length()==0)return 0;
        char[]strs=s.toCharArray();
        int result=0;
        for(int i=0;i<strs.length;i++){
            result=result*26+strs[i]-'A'+1;
        }
        return result;
    }
}
