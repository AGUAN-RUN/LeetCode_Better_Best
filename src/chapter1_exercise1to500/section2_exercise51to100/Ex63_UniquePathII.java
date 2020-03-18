package chapter1_exercise1to500.section2_exercise51to100;
/*一个机器人位于一个 m x n 网格的左上角
        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
        现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
        网格中的障碍物和空位置分别用 1 和 0 来表示
        说明：m 和 n 的值均不超过 100。*/
public class Ex63_UniquePathII {
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
        System.out.println(new Ex63_UniquePathII().uniquePathsWithObstacles(test));

    }
}
