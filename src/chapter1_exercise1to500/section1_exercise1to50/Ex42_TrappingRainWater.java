package chapter1_exercise1to500.section1_exercise1to50;

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
