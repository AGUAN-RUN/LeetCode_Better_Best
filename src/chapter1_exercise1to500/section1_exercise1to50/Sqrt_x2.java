package chapter1_exercise1to500.section1_exercise1to50;

public class Sqrt_x2 {
    //直接用java类库的Math.sqrt()更快,速度要快很多
    public int mySqrt(int x) {
        //小小优化，获取位数，result从  1，10，100，1000，10000开始找  1  100 10000
        //考虑边界溢出,i用long类型
        return (int)Math.sqrt(x);
    }
}
