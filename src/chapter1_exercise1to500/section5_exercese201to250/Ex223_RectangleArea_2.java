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
public class Ex223_RectangleArea_2 {
    //先找寻重叠部分

    //用时3ms  击败99.45% 的java提交
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //找出所有情况  一一判断  不是吧，应该有更好的办法
        //左边的直线取右(I)  右边的两天直线取左(J)  上面的两条直线取下(K)  下面的两条直线取上(M)

        //找寻左下和右上，通过IJKM 判断是否重叠，若重叠计算并减去重叠的面积
        //小小改进
        int s1=(D-B)*(C-A);
        int s2=(H-F)*(G-E);
        if(E>=C||A>=G||F>=D||B>=H)return s1+s2;
        int I=A>E?A:E;
        int J=B>F?B:F;
        int K=C>G?G:C;
        int M=D>H?H:D;
        return s1-(M-J)*(K-I)+s2;
    }
}
