package chapter1_exercise1to500.section2_exercise51to100;
/*Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*/

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


* */
public class Ex96_UniqueBinarySearchTrees {
    //未优化，下一轮优化将把已计算的n,numTrees(int n)保存在map中，如果map中能直接取到对于输入n，函数的值，将直接在map中取值
    //测试用例时间3702 ms 在所有 Java 提交中击败了 5.00% 的用户
    public int numTrees(int n) {
        if(n==0||n==1)return 1;
        int result=0;
        for(int i=1;i<=n;i++){
            result+=numTrees(i-1)*numTrees(n-i);
        }
        return result;
    }
}
