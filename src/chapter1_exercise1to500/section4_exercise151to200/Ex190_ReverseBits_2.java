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
public class Ex190_ReverseBits_2 {
    // you need treat n as an unsigned value
    //采用分治法的思想，在第一次提交的基础上改进该算法，采用掩码实现分治，减少位运算
    //1ms   时间复杂度O(1) 空间复杂度O(1)
    public int reverseBits(int n) {
       //前后16位交换
       n=(n>>>16)|(n<<16);
       //每16位前后8位交换
       n=((n>>>8)&0x00ff00ff)|((n<<8)&0xff00ff00);
       //每8位前后4位交换...每4位前后2位交换...每2位前后1位交换
       n=((n>>>4)&0x0f0f0f0f)|((n<<4)&0xf0f0f0f0);
       n=((n>>>2)&0x33333333)|((n<<2)&0xcccccccc);
       n=((n>>>1)&0x55555555)|((n<<1)&0xaaaaaaaa);
       return n;
    }
}
