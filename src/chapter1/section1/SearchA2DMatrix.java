package chapter1.section1;
/*编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。*/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        //rowIndex为目标行号
        int rowIndex=0;
        int left=0;
        int right=matrix.length-1;
        if(matrix[left][0]==target||matrix[right][0]==target)return true;
        //如果最后一行，第一个数都小于target,在最后一行找，没有就返回false
        if(matrix[right][0]<target){
            rowIndex=right;
            right=matrix[rowIndex].length-1;
            if(matrix[rowIndex][left]==target||matrix[rowIndex][right]==target)return true;
            while(right>left+1){
                int mid=(left+right)/2;
                if(matrix[rowIndex][mid]==target)return true;
                if(matrix[rowIndex][mid]>target){
                    right=mid;
                }else{
                    left=mid;
                }
            }
            return false;
        }
        //先用二分法在第一列找，没有找到就在某个特定的行进行二分查找
        while(right>left+1){
            int mid=(left+right)/2;
            if(matrix[mid][0]==target)return true;
            if(matrix[mid][0]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        rowIndex=left;
        left=0;
        right=matrix[rowIndex].length-1;
        if(matrix[rowIndex][left]==target||matrix[rowIndex][right]==target)return true;
        while(right>left+1){
            int mid=(left+right)/2;
            if(matrix[rowIndex][mid]==target)return true;
            if(matrix[rowIndex][mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return false;
    }
}
