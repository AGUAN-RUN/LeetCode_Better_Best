package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;
/*
格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

格雷编码序列必须以 0 开头。

 

示例 1:

输入: 2
输出: [0,1,3,2]
解释:
00 - 0
01 - 1
11 - 3
10 - 2

对于给定的 n，其格雷编码序列并不唯一。
例如，[0,2,3,1] 也是一个有效的格雷编码序列。

00 - 0
10 - 2
11 - 3
01 - 1
示例 2:

输入: 0
输出: [0]
解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。


* */
public class Ex89_GrayCode {
    //以下算法击败91%  --  --建议修改为用固定大小的静态数组实现，而不是使用java封装动态数组
    public List<Integer> grayCode(int n) {
        List<Integer>result=new ArrayList<>();
        if(n==0){
            result.add(0);
            return result;
        }
        int base=1;
        result.add(base-1);
        result.add(base);
        int lt=1;
        while(lt<n){
            base=(int)Math.pow(2,lt);
            int size=result.size();
            for(int i=size-1;i>=0;i--){
                result.add(base+result.get(i));
            }
            lt++;
        }
        return  result;
    }
}
