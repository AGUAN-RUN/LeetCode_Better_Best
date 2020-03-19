package chapter1_exercise1to500.section1_exercise1to50;

public class Ex8_StringToInteger {
    public int myAtoi(String str) {
        if(str==null||str.equals(""))return 0;
        int temp=0;
        int smbl;
        long res=0;
        int strlg=str.length();
        while(temp<strlg&&str.charAt(temp)==32){
            temp+=1;
        }
        if(temp>=strlg)return 0;
        if(str.charAt(temp)==45){
            smbl=-1;
        }else if(str.charAt(temp)==43){
            smbl=1;
        }else if(47<str.charAt(temp)&&str.charAt(temp)<58){
            smbl=1;
            res=str.charAt(temp)-48;
        }else{
            return 0;
        }
        for(int i=temp+1;i<strlg;i++){
            if(47<str.charAt(i)&&str.charAt(i)<58){
                res=res*10+str.charAt(i)-48;
                if(res*smbl>=(long)Integer.MAX_VALUE)return Integer.MAX_VALUE;
                if(res*smbl<=(long)Integer.MIN_VALUE)return Integer.MIN_VALUE;
            }else{
                break;
            }

        }
        return (int)res*smbl;

    }
}
