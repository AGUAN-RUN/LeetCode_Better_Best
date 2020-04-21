package chapter1_exercise1to500.section4_exercise151to200;
/*Given an input string, reverse the string word by word.

*Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 
Follow up:
For C programmers, try to solve it in-place in O(1) extra space.
* */
public class Ex151_ReverseWordsInAString {
    //使用java的API

    //用时1ms  击败100%的用户
    public String reverseWords(String s) {
        if(s==null||"".equals(s))return s;
        String[]strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if("".equals(strs[i]))continue;
            sb.append(strs[i]).append(" ");
        }
        if(sb.length()==0)return "";
        //去掉最后一个空格
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Ex151_ReverseWordsInAString test=new Ex151_ReverseWordsInAString();
        String s= " a   good   example ";
        test.reverseWords(s);
    }
}
