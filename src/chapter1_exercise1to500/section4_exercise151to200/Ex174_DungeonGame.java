package chapter1_exercise1to500.section4_exercise151to200;
/*
* The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid.
* Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons,
so the knight loses health (negative integers) upon entering these rooms;
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

Note:
The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
*/
public class Ex174_DungeonGame {
    //动态规划
    //JAVA用时2ms  击败96.40%
    //反方向求解更为简单   从终点到起点计算出所有格子到终点需要的最低血量
    public int calculateMinimumHP(int[][] dungeon) {
        //最后一行
        int n=dungeon.length-1;
        int m=dungeon[0].length-1;
        int value;
        for(int i=m-1;i>=0;i--){
            value=dungeon[n][i+1]>0?0:dungeon[n][i+1];
            dungeon[n][i]=dungeon[n][i]+value;
        }
        //最后一列
        for(int i=n-1;i>=0;i--){
            value=dungeon[i+1][m]>0?0:dungeon[i+1][m];
            dungeon[i][m]=dungeon[i][m]+value;
        }
        //统计的过程自底向上，自右到左，相邻有关，相隔无关
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                value=dungeon[i+1][j]>dungeon[i][j+1]?dungeon[i+1][j]:dungeon[i][j+1];
                value=value>0?0:value;
                dungeon[i][j]+=value;
            }
        }
        return dungeon[0][0]>0?0:dungeon[0][0];
    }
}
