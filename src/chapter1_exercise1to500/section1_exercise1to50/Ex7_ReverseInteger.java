package chapter1_exercise1to500.section1_exercise1to50;

public class Ex7_ReverseInteger {
    //直接一步收集，用long的变量收集结果
    public int reverse(int x){
        long res=0;
        while(x!=0){
            res=res*10+x%10;
            x/=10;
        }
        if(res>(long)(Math.pow(2,31)-1)||res<(long)(-Math.pow(2,31))) return 0;
        return (int)res;

    }
}
