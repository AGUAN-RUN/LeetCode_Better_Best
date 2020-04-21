package chapter3_exercise1001to1500.section7_exercise1401to1450;

import java.util.ArrayList;
import java.util.List;

/*Given an array of string words. Return all strings in words which is substring of another word in any order. 
String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
*/
public class Ex1408_StringMatchingInAnArray {
    //用时5ms 击败83%的用户
    public List<String> stringMatching(String[] words) {
        List<String> result=new ArrayList<>();
        if(words==null||words.length==0)return result;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(j==i)continue;
                if(words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
