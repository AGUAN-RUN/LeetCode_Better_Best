package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;

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
