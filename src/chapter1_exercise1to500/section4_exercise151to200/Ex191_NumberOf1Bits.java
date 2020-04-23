package chapter1_exercise1to500.section4_exercise151to200;
/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 
Follow up:
If this function is called many times, how would you optimize it?
*/
public class Ex191_NumberOf1Bits {
    // you need to treat n as an unsigned value

    //方法1  使用掩码判断每一位是否是 1
    //用时1ms  java击败99%
    public int hammingWeight(int n) {
        int i=1<<31;
        int result=0;
        while(i!=0){
            if((n&i)!=0)result++;
            i=i>>>1;
        }
        return result;
    }
}
