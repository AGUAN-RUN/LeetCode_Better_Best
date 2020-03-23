package chapter1_exercise1to500.section2_exercise51to100;

public class Ex91_DecodeWays {
    //使用分治法和递归方法求解
    //注意字符串中的0;
    //只打败了 11 %的提交代码，可以说效率非常低，待改进
    public int numDecodings(String s) {
        if(s==null||"".equals(s))return 0;
        char[]chars=s.toCharArray();
        return  numDecodingsWorker(chars,0);
    }
    public int numDecodingsWorker(char[]chars,int index){
        if(index<chars.length&&chars[index]=='0')return 0;
        if(index>=chars.length-1)return 1;
        if(chars[index]=='1'||(chars[index]=='2'&&chars[index+1]<'7')){
            return numDecodingsWorker(chars,index+1)+numDecodingsWorker(chars,index+2);
        }else{
            return numDecodingsWorker(chars,index+1);
        }
    }
}
