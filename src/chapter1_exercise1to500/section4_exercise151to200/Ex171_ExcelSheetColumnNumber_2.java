package chapter1_exercise1to500.section4_exercise151to200;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.
*/
public class Ex171_ExcelSheetColumnNumber_2 {
    //用时1ms 击败100%的用户

    //不去画蛇添足  toCharArray  速度要快一些
    public int titleToNumber(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result=result*26+s.charAt(i)-'A'+1;
        }
        return result;
    }
}
