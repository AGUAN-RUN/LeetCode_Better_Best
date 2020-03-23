package chapter1_exercise1to500.section2_exercise51to100;

public class Ex91_DecodeWays2 {
    public int numDecodings(String s) {
        //这道题有点像爬楼梯，一次可以走一步或者两步，但是这里只有在满足一些要求时，才能走两步
        //击败50% 有进步
        if(s==null||"".equals(s))return 0;
        char[]chars=s.toCharArray();
        //保证输入时有效可以解密的
        if(chars[0]=='0')return 0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]=='0'&&chars[i-1]!='1'&&chars[i-1]!='2')return 0;
        }
        int [] results=new int[chars.length+2];
        results[0]=1;
        results[1]=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]=='0'){
                results[i+1]=results[i];
                results[i+2]=results[i+1];
                i++;
            }else if((i+1)<chars.length&&chars[i+1]=='0'){
                results[i+1]=results[i];
            }else if(chars[i-1]=='1'||(chars[i-1]=='2'&&chars[i]<'7')){
                results[i+1]=results[i]+results[i-1];
            }else{
                results[i+1]=results[i];
            }
        }
        return results[chars.length];
    }
}
