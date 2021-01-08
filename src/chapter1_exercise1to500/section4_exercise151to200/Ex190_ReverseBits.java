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
/*
颠倒给定的 32 位无符号整数的二进制位。

 

示例 1：

输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
示例 2：

输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 

进阶:
如果多次调用这个函数，你将如何优化你的算法？


* */
public class Ex190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i=1;
        int j=1<<31;
        int st=31;
        int result=0;
        while(st>0){
            //注意java中  >>有符号右移 符号位不会移动 根据题目要求 这里应该使用>>>(无符号右移)移动符号位
            result=result|((n>>>st)&i)|((n<<st)&j);
            st-=2;
            i=i<<1;
            j=j>>>1;
        }
        return result;
    }
    public static void main(String[] args) {
        Ex190_ReverseBits test=new Ex190_ReverseBits();
        test.reverseBits(67);
    }


}
