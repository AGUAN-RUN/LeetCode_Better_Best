package chapter1_exercise1to500.section5_exercese201to250;
/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.



Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
* */
/*
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

每个矩形由其左下顶点和右上顶点坐标表示
示例:

输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
说明: 假设矩形面积不会超出 int 的范围。


* */
public class Ex223_RectangleArea {
    //先找寻重叠部分

    //用时3ms  击败99.45% 的java提交
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //找出所有情况  一一判断  不是吧，应该有更好的办法
        //左边的直线取右(I)  右边的两天直线取左(J)  上面的两条直线取下(K)  下面的两条直线取上(M)

        //找寻左下和右上，通过IJKM 判断是否重叠，若重叠计算并减去重叠的面积
        int I=A>E?A:E;
        int J=B>F?B:F;
        int K=C>G?G:C;
        int M=D>H?H:D;
        if(K>I&&M>J){
            return (D-B)*(C-A)-(M-J)*(K-I)+(H-F)*(G-E);
        }
        return (D-B)*(C-A)+(H-F)*(G-E);
    }
}
