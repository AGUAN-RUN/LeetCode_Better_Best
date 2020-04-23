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
