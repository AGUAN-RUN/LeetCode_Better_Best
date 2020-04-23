package chapter1_exercise1to500.section4_exercise151to200;
/*
Given a list of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Arrays;
import java.util.Comparator;

//常用的开发工具快捷键平时还是要多用用，用习惯了提高效率真的不只是一点点
public class Ex179_LargestNumber {
    //设计一个针对该问题特性的数组排序方法，完成数组排序后，直接遍历拼接到StringBuilder中，最后输出结果String
    //自定义一个comparetor

    //用时12ms 击败33.73%的java用户   克服万难，精益求精
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0)return "";
        //把int数组转化为String数组，排序，遍历拼接
        String[]strs=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            //返回0的时候表示相等，不交换顺序，返回1不相等不交换顺序，返回-1不相等要交换顺序
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i)>s2.charAt(i)){
                        return -1;
                    }else if(s1.charAt(i)<s2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });
        if("0".equals(strs[0]))return "0";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        return  sb.toString();
    }
    public static void main(String[] args) {
        int [] nums={1,33,455,2,425,4234,778,90,232,7,4};
        Ex179_LargestNumber test = new Ex179_LargestNumber();
        System.out.println(test.largestNumber(nums));
    }
}
