package chapter1.section1;

/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
*/

public class SpiralMatrixII {
    //把矩阵分解成一个一个圈来分别填充数字
        public int[][] generateMatrix(int n) {
            if(n<=0)return null;
            //计算矩阵圈数是奇数还是偶数
            boolean isDouble=n%2==0?true:false;
            int nums=n/2;
            int value=0;
            int[][]result=new int[n][n];
            int distance=0;
            for(int i=0;i<nums;i++){
                //计算这个圈的顶点之间的距离
                distance=n-2*i-1;
                int end=n-i-1;
                for(int j=i;j<end;j++){
                    result[i][j]=++value;
                    result[j][end]=value+distance;
                    result[end][n-j-1]=value+2*distance;
                    result[n-1-j][i]=value+3*distance;
                }
                value=value+3*distance;
            }
            //如果矩阵圈数是奇数
            if(!isDouble)result[nums][nums]=value+1;
            return result;
        }
}
