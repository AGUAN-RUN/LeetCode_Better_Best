package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


* */
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
