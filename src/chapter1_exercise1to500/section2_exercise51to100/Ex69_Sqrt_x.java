package chapter1_exercise1to500.section2_exercise51to100;

/*实现 int sqrt(int x) 函数。
        计算并返回 x 的平方根，其中 x 是非负整数。
        由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
        时间复杂度为  O("Math.pow(10,((n.length())-1)/2)")   */
/*
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。


* */
public class Ex69_Sqrt_x {
    public int mySqrt(int x) {
        //小小优化，获取位数，result从  1，10，100，1000，10000开始找  1  100 10000
        //考虑边界溢出,i用long类型
        String str=x+"";
        double left=Math.pow(10,((str.length())-1)/2);
        for(long i=(long)left;i<Integer.MAX_VALUE;i++){
            if(x<(i*i))return (int)i-1;
        }
        return 0;
    }

   // 2147395600   //289398
   public static void main(String[] args) {
        int value=2147395600;
       System.out.println(new Ex69_Sqrt_x().mySqrt(value));
       System.out.println();
   }
}
