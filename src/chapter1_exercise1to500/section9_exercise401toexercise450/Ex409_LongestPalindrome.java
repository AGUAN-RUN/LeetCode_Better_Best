package chapter1_exercise1to500.section9_exercise401toexercise450;

public class Ex409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s==null||"".equals(s))return 0;
       //用一个数组来保存遍历过程中没有用来  组成回文串的每个字符的个数，若目前遍历的字符在该数组的计数大于0，就消耗掉这两个字符串用来组成回文串，
        // 并把数组中这个字符的计数清零
        //ASCII字符编码对应的int数 是 0-127 共128个
        int result=0;
        int length=s.length();
        int[]charNums=new int[128];
        for(int i=0;i<length;i++){
            int num=charNums[s.charAt(i)];
            if(num==1){
                result+=2;
                charNums[s.charAt(i)]=0;
            }else{
                charNums[s.charAt(i)]=1;
            }
        }
        if(result==length)return result;
        return  result+1;
    }
}
