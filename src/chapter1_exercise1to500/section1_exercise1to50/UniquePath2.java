package chapter1_exercise1to500.section1_exercise1to50;

public class UniquePath2 {
        /*使用动态规划，保存开始的格子到走过的每个格子的路径数，到达
 某一个格子的路劲总数是到达这个格子左边的格子和右边格子的路径之和
 时间复杂度：m*n    时间复杂度大大降低
 */

    public int uniquePaths(int m, int n) {
        int[][]paths=new int[n][m];
        //先走右边
        for(int i=0;i<m;i++){
            paths[0][i]=1;
        }
        //再走下边
        for(int i=0;i<n;i++){
            paths[i][0]=1;
        }
        //从左至右，从上到下
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                paths[i][j]=paths[i-1][j]+paths[i][j-1];
            }
        }
        return paths[n-1][m-1];
    }
}
