package chapter1_exercise1to500.section2_exercise51to100;
/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
        问总共有多少条不同的路径？   m和n不超过一百*/
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

 

示例 1：


输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109


* */
public class Ex62_UniquePath1 {
    //这个递归方法可以就是效率太低了，答案正确,但是运行超时，问题规模增加1，运行时间就要增加 指数倍
    //这里就不作m，n小于零的判断了
    public int uniquePaths(int m, int n) {
        //一个引用来记录结果，按引用传递的
        long [] result = new long []{1};
        //每走一步，记录机器人的位置，将位置传入子方法
        uniquePathsWorker(result,m,n,1,1);
        return (int)result[0];
    }
    public void uniquePathsWorker(long[]rslt,int x,int y,int rx,int ry){
        if(x==rx||y==ry)return;
        rslt[0]=rslt[0]+1;
        uniquePathsWorker(rslt,x,y,rx+1,ry);
        uniquePathsWorker(rslt,x,y,rx,ry+1);
    }
}
