package chapter1_exercise1to500.section1_exercise1to50;
/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


* */
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
