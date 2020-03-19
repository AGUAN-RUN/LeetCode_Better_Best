package chapter1_exercise1to500.section9_exercise401toexercise450;

public class Ex409_LongestPalindrome_2 {
    public int longestPalindrome(String s) {
      if(s==null||"".equals(s))return 0;
    //用一个数组来保存遍历过程中没有用来  组成回文串的每个字符的个数，若目前遍历的字符在该数组的计数大于0，就消耗掉这两个字符串用来组成回文串
    // 并把数组中这个字符的计数清零
    //ASCII字符编码对应的int数 是 0-127 共128个
      int result=0;
      int[]charNums=new int[128];
      //这次执行速度比第一次提交代码运行速度提高了50%。字符串先转化成字符数组来处理，遍历字符数组比遍历字符串获取每个位置的字符效率要高些
      char[]charArray=s.toCharArray();
        for(int i=0;i<charArray.length;i++){
        int num=charNums[charArray[i]];
        if(num==1){
            result+=2;
            charNums[charArray[i]]=0;
        }else{
            charNums[charArray[i]]=1;
        }
    }
        if(result==charArray.length)return result;
        return  result+1;
}
}
