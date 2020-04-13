package chapter1_exercise1to500.section4_exercise151to200;
/*
* Given a positive integer, return its corresponding column title as appear in an Excel sheet.
* */
public class Ex168_ExcelSheetColumnTitle_2 {
    //妥妥的26进制
    //优化，使用StringBuild容器来缓存 最后一次一步生成字符串，取代之前在循环过程不断拼接字符串的过程
    //用卡车把货装满在运往目的地，不要装了一点点货就往目的地运，这样效率很低且浪费“燃油”

    //用时0ms  击败100%的用户
    public String convertToTitle(int n) {
        char[]strs=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuilder result=new StringBuilder();
        n=n-1;
        while(n>=26){
            int value=n%26;
            result=result.append(strs[value]);
            n=n/26-1;
        }
        result=result.append(strs[n]);
        return result.reverse().toString();
    }
}
