package chapter1.section1;

public class LengthOfLastWord {
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
}
