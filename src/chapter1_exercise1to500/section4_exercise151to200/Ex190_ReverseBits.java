package chapter1_exercise1to500.section4_exercise151to200;
/*
Reverse bits of a given 32 bits unsigned integer.

Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and
output will be given as signed integer type and should not affect your implementation,
as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 
above the input represents the signed integer -3 and the output represents the signed integer -1073741825.

Follow up:
If this function is called many times, how would you optimize it?
* */
public class Ex190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      String s=Integer.toBinaryString(n);
      char[]chs=s.toCharArray();
      int i=0,j=chs.length-1;
      while(i<j){
          char c=chs[i];
          chs[i]=chs[j];
          chs[j]=c;
      }


    }
}
