package chapter1_exercise1to500.section4_exercise151to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
*/
/*
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

 

示例 1：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]
 

提示：

0 <= s.length <= 105
s[i] 为 'A'、'C'、'G' 或 'T'


* */
public class Ex187_RepeatedDNASequences {
    //用时25ms   击败56.98%的java提交   由于使用java map来作为辅助容器，效率比直接使用数组来做辅助容器要低很多，尝试改进
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>result = new ArrayList<>();
        if(s==null||s.length()<11)return result;
        Map<String,Integer> tempMap=new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String str=s.substring(i,i+10);
            Integer res=tempMap.get(str);
            if(res==null){
                tempMap.put(str,i+9);
            }else if(res!=-1){
                result.add(str);
                tempMap.put(str,-1);
            }
        }
        return result;
    }
}
