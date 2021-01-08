package chapter1_exercise1to500.section1_exercise1to50;
/*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
* */
/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G


* */
public class Ex6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s==null||s.length()<=numRows||numRows==1)return s;
        int n=s.length();
        char [][] strings=new char[numRows][n];
        int row=0;
        int column=0;
        int rs=1;
        int cs=0;
        int temp=0;
        char [] result=new char[n];
        for(int i=0;i<n;i++){
            strings[row][column]=s.charAt(i);
            if(row==0){
                rs=1;
                cs=0;
            }
            if(row==(numRows-1)){
                rs=-1;
                cs=1;
            }
            row+=rs;
            column+=cs;
        }
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<strings[i].length;j++){
                if(strings[i][j]!=0){
                    result[temp++]=strings[i][j];
                }
            }
        }
        return new String(result);
    }
}
