package chapter1_exercise1to500.section6_exercese251to300;
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
* */
public class Ex264_UglyNumberII {
    //3ms  打败了87.82的用户

    //静态初始化1690个丑数到 类变量中  如果类初始化之后多次调用可以直接从类变量中取值
    private static int[]Uglys=new int[1690];
    static {
        int i=0;
        int n2=0,n3=0,n5=0;
        Uglys[i++]=1;
        while(i<1690){
            int a=2*Uglys[n2];
            int b=3*Uglys[n3];
            int c=5*Uglys[n5];
            Uglys[i]=Math.min(Math.min(a,b),c);
            if(a==Uglys[i])n2++;
            if(b==Uglys[i])n3++;
            if(c==Uglys[i++])n5++;
        }
    }
    public int nthUglyNumber(int n) {
        return Uglys[n-1];
    }
}
