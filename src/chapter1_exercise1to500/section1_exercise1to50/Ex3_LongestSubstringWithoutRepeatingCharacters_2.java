package chapter1_exercise1to500.section1_exercise1to50;

import java.util.HashMap;
import java.util.Map;

public class Ex3_LongestSubstringWithoutRepeatingCharacters_2 {
    //优化
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(), a=0;
        int i=0;
        //创建一个数组，在遍历字符串时，保存128个ASCII字符在本次循环之前 在所有已经遍历的字符中的最大索引位置加一

        int [] index=new int[128];
        for(int j=0;j<n;j++){
            //若存在重复，就从前面相邻的重复元素的下一个元素开始重新统计不重复的字符串长度，并参与后面的迭代
            i=Math.max(index[s.charAt(j)],i);
            //a保存最长串的长度
            a=Math.max(a,j-i+1);
            index[s.charAt(j)]=j+1;
        }
        return a;
    }
}
