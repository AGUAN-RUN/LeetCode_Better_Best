package chapter1.section1_99;

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

    public static void main(String[] args) {
        String str="，";
        char[]chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);

        }
    }
}
