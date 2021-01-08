package chapter1_exercise1to500.section1_exercise1to50;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9
 

提示：

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105


* */
public class Ex42_TrappingRainWater {
    public int trap(int[] height) {
        if(height==null||height.length<3)return 0;
        int u=0;
        int p;
        int result=0;
        while(u+1<height.length){
            p=1;
            for(int i=u;i<height.length;i++){
                if(height[i]>=height[u]){
                    u=i;
                }else{
                    break;
                }
            }
            if(u+1>=height.length)return result;
            for(int i=u+2;i<height.length;i++){
                if(height[i]>=height[u]){
                    p=i;
                    for(int j=u+1;j<p;j++){
                        result=result+height[u]-height[j];
                    }
                    u=p;
                    p=-u;
                    break;
                }
            }
            if(p!=-u){
                int max=height[u+1];
                p=u+1;
                for(int i=u+2;i<height.length;i++){
                    if(height[i]>=max){
                        p=i;
                        max=height[i];
                    }
                }
                if(p!=u+1){
                    for(int j=u+1;j<p;j++){
                        result=result+height[p]-height[j];
                    }
                }
                u=p;
            }
        }

        return result;
    }
}
