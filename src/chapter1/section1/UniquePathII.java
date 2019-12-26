package chapter1.section1;

public class UniquePathII {
    //该算法时间复杂度为m*n，使用了M*N空间
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //考虑无输入
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0][0]==1)return 0;

        //不采用空间优化的动态规划求解，使用n*m数组，考虑障碍物
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        //考虑一个元素的情况,不是障碍物
        if(n==1&&m==1)return 1;
        int[][]result = new int[n][m];
        result[0][0]=1;
        //第一轮向下
        for(int i=1;i<n;i++){
            if(obstacleGrid[i][0]==1)break;
            result[i][0]=result[i-1][0];
        }
        //第一轮向右
        for(int i=1;i<m;i++){
            if(obstacleGrid[0][i]==1)break;
            result[0][i]=result[0][i-1];
        }
        //从上至下，从左至右
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1)continue;
                result[i][j]=result[i-1][j]+result[i][j-1];
            }
        }
        return result[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][]test=new int[][]{{0,0,0,1},{0,0,1,0},{0,0,0,0}};
        System.out.println(new UniquePathII().uniquePathsWithObstacles(test));

    }
}
