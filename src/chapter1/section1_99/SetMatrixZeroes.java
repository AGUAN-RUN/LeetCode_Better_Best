package chapter1.section1_99;

/*73.给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
* 时间复杂度 O(m*n)
* 空间复杂度 O(1)
* */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //原地算法  不使额外空间
        //一个直接的解决方案是使用  O(mn) 的额外空间
        //用第一行的元素来决定每一列是否为零，用第一列的元素来决定每一行是否为0
        //考虑程序的鲁棒性
        if(matrix==null||matrix.length==0)return;
        //第一行是否都为0
        boolean isFirstRowZero=false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                isFirstRowZero=true;
            }
        }
        //第一列是否都为0
        boolean isFirstColumnZero=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                isFirstColumnZero=true;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //先判断除了第一行，第一列，其他行数是否为零
        //先行
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //后列
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        //matrixp[0][0]为0,第一行第一列是都为0
        if(isFirstColumnZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(isFirstRowZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}
