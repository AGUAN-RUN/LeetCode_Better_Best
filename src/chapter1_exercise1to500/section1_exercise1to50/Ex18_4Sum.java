package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex18_4Sum {
    //第一次提交，还未优化
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int a,b,c,d;

        for(int i=0;i<nums.length;i++){
            a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                b=nums[j];
                for(int m=j+1;m<nums.length;m++){
                    c=nums[m];
                    skip:
                    for(int n=m+1;n<nums.length;n++){
                        d=nums[n];
                        if((a+b+c+d)==target){
                            ArrayList<Integer> temp=new ArrayList<>();
                            temp.add(a);
                            temp.add(b);
                            temp.add(c);
                            temp.add(d);
                            Collections.sort(temp);
                            for(int p=0;p<result.size();p++){
                                if(temp.equals(result.get(p))){
                                    break skip;
                                }
                            }
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;


    }
}
