package chapter1_exercise1to500.section1_exercise1to50;

import java.util.HashMap;
import java.util.Map;

public class Ex3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)return -1;
        int res=0;
        int left=0;
        char[]chars=s.toCharArray();
        Map<Integer,Character> tempMap=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(tempMap.containsValue(chars[i])){
                while(tempMap.get(left)!=chars[i]){
                    tempMap.remove(left);
                    left+=1;
                }
                tempMap.remove(left++);
            }
            tempMap.put(i,chars[i]);
            res=tempMap.size()>res?tempMap.size():res;
        }
        return res;

    }
}
