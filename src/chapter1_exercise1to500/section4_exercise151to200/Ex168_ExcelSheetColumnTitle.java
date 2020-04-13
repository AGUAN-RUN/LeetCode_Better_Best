package chapter1_exercise1to500.section4_exercise151to200;
/*
* Given a positive integer, return its corresponding column title as appear in an Excel sheet.
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
