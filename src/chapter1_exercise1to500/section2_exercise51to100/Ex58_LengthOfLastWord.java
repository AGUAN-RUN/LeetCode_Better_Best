package chapter1_exercise1to500.section2_exercise51to100;
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

 

示例:

输入: "Hello World"


* */
public class Ex58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null)return 0;
        //去掉左右空格
        s=s.trim();
        if(s.equals(""))return 0;
        char[]chars=s.toCharArray();
        int result=0       ;
        for(int i=chars.length-1;i>=0;i--){
            if((int)chars[i]==32)break;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String str="，";
        char[]chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);

        }
    }
}
