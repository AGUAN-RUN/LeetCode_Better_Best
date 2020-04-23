package chapter1_exercise1to500.section4_exercise151to200;
/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 
Follow up:
If this function is called many times, how would you optimize it?
*/
public class Ex191_NumberOf1Bits_2 {
    // you need to treat n as an unsigned value

    //方法2 根据  n&(n-1) 会把n中最后一位1置为0 的特点 设计以下算法
    //和方法1相比，方法二不会判断  二进制前面多余的0  这就是  精益求精的工程师（工匠）精神
    //用时1ms  java击败99%
    public int hammingWeight(int n) {
        int result=0;
        //就算是负数，最后 (n-1)会溢出为int最大整数 n&(n-1) 此时将最后的符号位置为0
        while(n!=0){
            result++;
            n=n&(n-1);
        }
        return result;
    }

    public static void main(String[] args) {
        int i=Integer.MIN_VALUE;
        System.out.println(i-1);
    }
}
