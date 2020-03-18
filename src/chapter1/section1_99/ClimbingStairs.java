package chapter1.section1_99;
  /* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
           每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
           注意：给定 n 是一个正整数。*/
public class ClimbingStairs {
    //使用递归求解,递归算法正确，但是leetcode上超时了,考虑使用动态规划的方法求解，避免子问题的重复求解降低运行效率
    // T（n）=T（n-2）+T（n-1）；
    public int climbStairs(int n) {
        if(0<=n&&n<2)return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
