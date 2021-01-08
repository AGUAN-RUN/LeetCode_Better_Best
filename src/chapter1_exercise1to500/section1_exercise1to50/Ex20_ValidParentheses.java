package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true


* */
public class Ex20_ValidParentheses {
    public boolean isValid(String s) {
        char[]chars=s.toCharArray();
        if(s==null||s.equals(""))return true;
        List<Character> charList=new ArrayList<>();
        charList.add(chars[0]);
        for(int i=1;i<chars.length;i++){
            if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
                charList.add(chars[i]);
            }
            if(chars[i]==')'){
                if(charList.size()>0&&charList.get(charList.size()-1)==(chars[i]-1)){
                    charList.remove(charList.size()-1);
                }else{
                    charList.add(chars[i]);
                }
            }
            if(chars[i]==']'||chars[i]=='}'){
                if(charList.size()>0&&charList.get(charList.size()-1)==(chars[i]-2)){
                    charList.remove(charList.size()-1);
                }else{
                    charList.add(chars[i]);
                }


            }

        }
        if(charList.size()==0){
            return true;
        }
        return false;
    }
}
