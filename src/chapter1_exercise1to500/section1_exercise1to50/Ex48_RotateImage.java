package chapter1_exercise1to500.section1_exercise1to50;

public class Ex48_RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length<1)return;
        int n=matrix.length;
        int num=n/2;
        //从正方形矩阵的外圈到内圈依次进行原地替换，一个圈轮回4次完成所有替换
        while(num>0){
            for(int i=num-1;i<n-num;i++){
                int x=num-1,y=i;
                int temp=matrix[x][y];
                for(int j=0;j<4;j++){
                    int z=x;
                    x=y;
                    y=n-z-1;
                    int ret=temp;
                    temp=matrix[x][y];
                    matrix[x][y]=ret;
                }
            }
            num--;
        }
    }
}
