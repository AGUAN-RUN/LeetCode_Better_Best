package chapter1_exercise1to500.section1_exercise1to50;

public class Ex50_Pow {
    public double myPow(double x, int n) {
        //使用分治思想，降低时间复杂度，由O(n)-->O(lgn);注意n可正可负;还得要考虑溢出问题  （int类型）负数的最小值直接取绝对值会导致溢出
        long m=n;
        double dt=m%2;
        if(x==0)return 0;
        double y=Math.abs(x);
        if(y==1)return dt==0?y:x;
        if(m==0)return 1;
        if(m<0)y=1/y;
        m=Math.abs(m);
        double result=myPowCalculate(y,m);
        if(x<0&&m%2==1)return -result;
        return result;
    }
    public double myPowCalculate(double x,long n){
        if(n==1)return x;
        double temp=myPowCalculate(x,n/2);
        if(n%2==1){
            return temp*temp*x;
        }else{
            return temp*temp;
        }
    }
}
