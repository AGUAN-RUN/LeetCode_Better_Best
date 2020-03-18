package chapter1.section800_899;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //两个矩形相交必须满足条件，矩阵在x轴上有交集且矩阵在y轴上有交集
        if(rec1==null||rec2==null)return false;
        //两个矩阵在x轴的范围有交集并且  两个矩阵在y轴的范围有交集
        if(rec1[0]<rec2[2]&&rec1[2]>rec2[0]&&rec1[1]<rec2[3]&&rec1[3]>rec2[1])return true;
        return false;


    }
}