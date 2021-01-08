package chapter1_exercise1to500.section3_exercise101to150;

import java.util.ArrayList;
import java.util.List;

/*
* Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


。*/

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？


* */
public class Ex119_PascalsTriangleII {
    /*
    杨辉三角的性质：
    每行端点与结尾的数为1.
    每个数等于它上方两数之和。
    每行数字左右对称，由1开始逐渐变大。
    第n行的数字有n项。
    第n行数字和为2n-1。
    第n行的m个数可表示为 C(n-1，m-1)，即为从n-1个不同元素中取m-1个元素的组合数。
    第n行的第m个数和第n-m+1个数相等 ，为组合数性质之一*/

    //利用杨辉三角的性质设计算法
    //运行时间0ms  击败100%
    public List<Integer> getRow(int rowIndex) {
            List<Integer> result=new ArrayList<>();
            if(rowIndex<0)return result;
            result.add(1);
            long value=1;
            long n=rowIndex;
            for(long m=1;m<=rowIndex;m++){
          //一下方法计算会产生符号位溢出，出现负数
          /*  p=p*n;
                n-=1;
                q=q*m;
                result.add(p/q);*/
                value=value*n/m;
                result.add((int)value);
                n-=1;
            }
            return result;
        }

    public static void main(String[] args) {
        Ex119_PascalsTriangleII test=new Ex119_PascalsTriangleII();
        test.getRow(33);
    }
}
