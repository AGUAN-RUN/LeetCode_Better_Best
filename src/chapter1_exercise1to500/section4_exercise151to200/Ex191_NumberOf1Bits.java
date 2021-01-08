package chapter1_exercise1to500.section4_exercise151to200;
/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 
Follow up:
If this function is called many times, how would you optimize it?
*/
/*
编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

 

提示：

请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 

进阶：

如果多次调用这个函数，你将如何优化你的算法？
 

示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
示例 2：

输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
示例 3：

输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 

提示：

输入必须是长度为 32 的 二进制串 。


* */
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
