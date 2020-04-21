package chapter1_exercise1to500.section4_exercise151to200;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.
*/
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
