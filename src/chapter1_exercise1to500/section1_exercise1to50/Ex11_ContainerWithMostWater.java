package chapter1_exercise1to500.section1_exercise1to50;

public class Ex11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int j=0;
        int k=height.length-1;
        int max=0;
        while(k>j){
            if(height[j]>height[k]){
                if(max<height[k]*(k-j))max=height[k]*(k-j);
                while(height[k-1]<height[k]&&k>j)k--;
                k--;
            }else{
                if(max<height[j]*(k-j))max=height[j]*(k-j);
                while(height[j+1]<height[j]&&k>j)j++;
                j++;
            }

        }
        return max;
    }
}
